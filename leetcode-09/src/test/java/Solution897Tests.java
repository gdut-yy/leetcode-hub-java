import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution897Tests {
    private final Solution897 solution897 = new Solution897();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        // expected
        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(2);
        expected.right.right = new TreeNode(3);
        expected.right.right.right = new TreeNode(4);
        expected.right.right.right.right = new TreeNode(5);
        expected.right.right.right.right.right = new TreeNode(6);
        expected.right.right.right.right.right.right = new TreeNode(7);
        expected.right.right.right.right.right.right.right = new TreeNode(8);
        expected.right.right.right.right.right.right.right.right = new TreeNode(9);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution897.increasingBST(root)));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        // expected
        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(5);
        expected.right.right = new TreeNode(7);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution897.increasingBST(root)));
    }
}
