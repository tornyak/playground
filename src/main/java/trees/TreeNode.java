package trees;

public class TreeNode<K extends Comparable<K>,V> implements Comparable<TreeNode<K,V>>{

    private K key;
    private V value;
    private TreeNode<K,V> parent;
    private TreeNode<K,V> left;
    private TreeNode<K,V> right;

    public TreeNode(K key, V value, TreeNode<K,V> parent) {
        this.key=key;
        this.value = value;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public TreeNode(K key, V value) {
        this.key=key;
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public TreeNode<K,V> addLeftChild (K key, V value) {
        this.left=new TreeNode<>(key, value,this);
        return this.left;
    }
    public TreeNode<K,V> addRightChild (K key, V value) {
        this.right=new TreeNode<>(key, value,this);
        return this.right;
    }

    public void visit() {
        System.out.print(this.value);
    }
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public TreeNode<K,V> getParent() {
        return parent;
    }

    public void setParent(TreeNode<K,V> parent) {
        this.parent = parent;
    }

    public TreeNode<K,V> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<K,V> left) {
        this.left = left;
    }

    public TreeNode<K,V> getRight() {
        return right;
    }

    public void setRight(TreeNode<K,V> right) {
        this.right = right;
    }

    @Override
    public int compareTo(TreeNode<K, V> treeNode) {
        return this.key.compareTo(treeNode.getKey());
    }
}
