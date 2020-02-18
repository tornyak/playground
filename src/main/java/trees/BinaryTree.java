package trees;

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
}
