import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution814Tests {
    private final Solution814 solution814 = new Solution814();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        // expected
        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(0);
        expected.right.right = new TreeNode(1);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution814.pruneTree(root)));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        // expected
        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(1);
        expected.right.right = new TreeNode(1);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution814.pruneTree(root)));
    }

    @Test
    public void example3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(0);
        // expected
        TreeNode expected = new TreeNode(1);
        expected.left = new TreeNode(1);
        expected.right = new TreeNode(0);
        expected.left.left = new TreeNode(1);
        expected.left.right = new TreeNode(1);
        expected.right.right = new TreeNode(1);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution814.pruneTree(root)));
    }
}
