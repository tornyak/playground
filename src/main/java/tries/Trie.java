package tries;

import java.util.LinkedList;
import java.util.Queue;

public class Trie<V> {
    private static int radix =256;
    private Node root = new Node();

    private static class Node {
        private Object value; //Java does not support array of generics
        private Node[] next = new Node[radix];
    }

    public void put (String key, V value) {
        root=put(root,key,value,0);
    }

    private Node put(Node node, String key, V value, int depth) {
        if (node==null) node=new Node();
        if (depth==key.length()) {
            node.value=value;
            return node;
        }
        char c=key.charAt(depth);
        node.next[c]=put(node.next[c],key,value,depth+1);
        return node;
    }

    public V get(String key) {
        Node node=get(root,key,0);
        if (node==null) return null;
        return (V) node.value;
    }

    private Node get(Node node, String key, int depth) {
        if(node==null) return null;
        if (depth==key.length()) return node;
        char c=key.charAt(depth);
        return get(node.next[c],key,depth+1);
    }
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    private Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> queue=new LinkedList<>();
        collect(get(root,prefix,0),prefix,queue);
        return queue;
    }

    private void collect(Node node, String prefix, Queue<String> queue) {
        if (node==null) return;
        if (node.value != null) queue.add(prefix);
        for (char c = 0; c < radix; c++) {
            collect(node.next[c],prefix+c,queue);
        }
    }
    private Iterable<String> keysThatMatch(String pattern) {
        Queue<String> queue=new LinkedList<>();
        collect(root,"",pattern,queue);
        return queue;
    }

    private void collect(Node node, String prefix, String pattern, Queue<String> queue) {
        int depth=prefix.length();
        if (node==null) return;
        if (depth==pattern.length() && node.value != null) queue.add(prefix);
        if (depth==pattern.length()) return;
        char next=pattern.charAt(depth);
        for (char c = 0; c < radix; c++) {
            if (next=='.' || next==c)
                collect(node.next[c],prefix+c,pattern, queue);
        }
    }

    public void delete (String key) {
        root=delete(root,key,0);
    }

    private Node delete(Node node, String key, int depth) {
        if (node==null) return null;
        if (depth==key.length()) node.value=null;
        else {
            char c=key.charAt(depth);
            node.next[c]=delete(node.next[c],key,depth+1);
        }
        if (node.value!=null) return node;
        for (char c = 0; c < radix; c++)
            if (node.next[c]!=null) return node;
        return null;
    }
}
