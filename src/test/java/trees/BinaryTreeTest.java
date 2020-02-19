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
        System.out.println("");

        System.out.println("level-order traversal: ");
        tree.levelOrderTraversal();
    }

    @Test
    public void getTest() {
        BinaryTree<Integer,String> tree = new BinaryTree<>();
        tree.put (4,"A");
        tree.put (2,"B");
        tree.put (6,"C");
        tree.put (1,"D");
        tree.put (3,"E");
        tree.put (5,"F");
        tree.put (7,"G");

        String s=tree.get(6);
        assertEquals("C",s);

        s=tree.get(100);
        assertNull(s);

        tree.put(6,"test");
        s=tree.get(6);
        assertEquals("test",s);
    }

    @Test
    public void getMin() {
        BinaryTree<Integer,String> tree = new BinaryTree<>();
        tree.put (4,"A");
        tree.put (2,"B");
        tree.put (6,"C");
        tree.put (1,"D");
        tree.put (3,"E");
        tree.put (5,"F");
        tree.put (7,"G");

        int i=tree.min();
        assertEquals(1,i);
    }

    @Test
    public void deleteMin() {
        BinaryTree<Integer,String> tree = new BinaryTree<>();
        tree.put (4,"A");
        tree.put (2,"B");
        tree.put (6,"C");
        tree.put (1,"D");
        tree.put (3,"E");
        tree.put (5,"F");
        tree.put (7,"G");

        int i=tree.min();
        assertEquals(1,i);

        tree.deleteMin();
        System.out.println("Post-order traversal: ");
        tree.postOderTraversal();
        System.out.println("");
    }

    @Test
    public void delete() {
        BinaryTree<Integer,String> tree = new BinaryTree<>();
        tree.put (4,"A");
        tree.put (2,"B");
        tree.put (6,"C");
        tree.put (1,"D");
        tree.put (3,"E");
        tree.put (5,"F");
        tree.put (7,"G");

        int i=tree.min();
        assertEquals(1,i);

        tree.delete(2);
        System.out.println("Post-order traversal: ");
        tree.postOderTraversal();
        System.out.println("");
    }
}