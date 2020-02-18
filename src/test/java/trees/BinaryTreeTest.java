package trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void traverseTree() {
        BinaryTree<Integer,String> tree = new BinaryTree<>();
        tree.put (4,"A");
        tree.put (2,"B");
        tree.put (6,"C");
        tree.put (1,"D");
        tree.put (3,"E");
        tree.put (5,"F");
        tree.put (7,"G");

        System.out.println("Pre-order traversal: ");
        tree.preOrderTraversal();
        System.out.println("");

        System.out.println("Post-order traversal: ");
        tree.postOderTraversal();
        System.out.println("");

        System.out.println("In-order traversal: ");
        tree.inOderTraversal();
    }


}