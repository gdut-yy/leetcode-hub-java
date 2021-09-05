import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution173Tests {
    @Test
    public void example1() {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        Solution173.BSTIterator bstIterator = new Solution173.BSTIterator(root);
        Assertions.assertEquals(3, bstIterator.next());
        Assertions.assertEquals(7, bstIterator.next());
        Assertions.assertTrue(bstIterator.hasNext());
        Assertions.assertEquals(9, bstIterator.next());
        Assertions.assertTrue(bstIterator.hasNext());
        Assertions.assertEquals(15, bstIterator.next());
        Assertions.assertTrue(bstIterator.hasNext());
        Assertions.assertEquals(20, bstIterator.next());
        Assertions.assertFalse(bstIterator.hasNext());
    }
}
