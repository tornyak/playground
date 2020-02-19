package trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<K extends Comparable<K>,V> {
    TreeNode<K,V> root;

    public BinaryTree(TreeNode<K, V> root) {
        this.root = root;
    }

    public BinaryTree() {
        this.root = null;
    }

    public void put (K key, V value) {
        root=put(root,key,value);
    }

    private TreeNode<K,V> put (TreeNode<K,V> node, K key, V value) {

        if (node==null) return new TreeNode<>(key,value);
        int compare=key.compareTo(node.getKey());
        if (compare<0) node.setLeft(put(node.getLeft(),key,value));
        else if (compare>0) node.setRight(put(node.getRight(),key,value));
        else node.setValue(value);
        return node;
    }

    private void preOrderTraversal (TreeNode<K,V> node) {
        if (node!=null) {
            node.visit();
            preOrderTraversal(node.getLeft());
            preOrderTraversal(node.getRight());
        }
    }
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    private void postOrderTraversal (TreeNode<K,V> node) {
        if (node!=null) {
            postOrderTraversal(node.getLeft());
            postOrderTraversal(node.getRight());
            node.visit();
        }
    }

    public void postOderTraversal() {
        postOrderTraversal(root);
    }

    private void inOrderTraversal (TreeNode<K,V> node) {
        if (node!=null) {
            inOrderTraversal(node.getLeft());
            node.visit();
            inOrderTraversal(node.getRight());
        }
    }

    public void inOderTraversal() {
        inOrderTraversal(root);
    }

    public void levelOrderTraversal() {
        Queue<TreeNode<K,V>> queue = new LinkedList<>();
        TreeNode<K,V> curr;
        queue.add(root);
        while (!queue.isEmpty()) {
            curr=queue.remove();
            if (curr!=null) {
                curr.visit();
                queue.add(curr.getLeft());
                queue.add(curr.getRight());
            }
        }
    }



    public V get (K key) {
        return get (root,key);
    }

    private V get(TreeNode<K,V> node, K key) {
        if (node==null) return null;
        int compare=key.compareTo(node.getKey());
        if (compare<0) return get(node.getLeft(),key);
        else if (compare>0) return get(node.getRight(),key);
        else return node.getValue();
    }

    public K min () {
        return min(root).getKey();
    }

    private TreeNode<K,V> min(TreeNode<K,V> node) {
        if (node.getLeft()==null) return node;
        return min(node.getLeft());
    }

    public void deleteMin() {
        root=deleteMin(root);
    }

    private TreeNode<K,V> deleteMin (TreeNode<K,V> node) {
        if (node.getLeft()==null) return node.getRight();
        node.setLeft(deleteMin(node.getLeft()));
        return node;
    }

    public void delete (K key){
        root=delete(root,key);
    }

    private TreeNode<K,V> delete(TreeNode<K,V> node, K key) {
        if (node==null) return null;
        int compare=key.compareTo(node.getKey());
        if (compare<0) node.setLeft(delete(node.getLeft(),key));
        else if (compare>0) node.setRight(delete(node.getRight(),key));
        else {
            if (node.getLeft()==null) return node.getRight();
            if (node.getRight()==null) return node.getLeft();
            TreeNode<K,V> temp = node;
            node=min(temp.getRight());
            node.setRight(deleteMin(temp.getRight()));
            node.setLeft(temp.getLeft());
        }
        return node;
    }
}
