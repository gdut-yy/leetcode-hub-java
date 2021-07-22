import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution114Tests {
    private final Solution114 solution114 = new Solution114();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(2);
        expected.right.right = new TreeNode(3);
        expected.right.right.right = new TreeNode(4);
        expected.right.right.right.right = new TreeNode(5);
        expected.right.right.right.right.right = new TreeNode(6);
        solution114.flatten(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, root));
    }

    @Test
    public void example2() {
        TreeNode root = null;
        TreeNode expected = null;
        solution114.flatten(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, root));
    }

    @Test
    public void example3() {
        TreeNode root = new TreeNode(0);
        TreeNode expected = new TreeNode(0);
        solution114.flatten(root);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, root));
    }
}
