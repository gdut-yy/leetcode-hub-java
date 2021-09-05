import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution919Tests {
    @Test
    public void example1() {
        TreeNode root = new TreeNode(1);
        Solution919.CBTInserter cbtInserter = new Solution919.CBTInserter(root);
        Assertions.assertEquals(1, cbtInserter.insert(2));
        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, root));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        Solution919.CBTInserter cbtInserter = new Solution919.CBTInserter(root);
        Assertions.assertEquals(3, cbtInserter.insert(7));
        Assertions.assertEquals(4, cbtInserter.insert(8));
        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(2);
        expected.right = new TreeNode(3);
        expected.left.left = new TreeNode(4);
        expected.left.right = new TreeNode(5);
        expected.right.left = new TreeNode(6);
        expected.right.right = new TreeNode(7);
        expected.left.left.left = new TreeNode(8);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, cbtInserter.get_root()));
    }
}
