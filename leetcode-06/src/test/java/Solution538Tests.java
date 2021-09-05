import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution538Tests {
    private final Solution538 solution538 = new Solution538();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        root.left.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(8);
        // expected
        TreeNode expected = new TreeNode(30);
        expected.left = new TreeNode(36);
        expected.right = new TreeNode(21);
        expected.left.left = new TreeNode(36);
        expected.left.right = new TreeNode(35);
        expected.right.left = new TreeNode(26);
        expected.right.right = new TreeNode(15);

        expected.left.right.right = new TreeNode(33);
        expected.right.right.right = new TreeNode(8);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution538.convertBST(root)));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        // expected
        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(1);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution538.convertBST(root)));
    }

    @Test
    public void example3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        // expected
        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(3);
        expected.right = new TreeNode(2);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution538.convertBST(root)));
    }

    @Test
    public void example4() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        // expected
        TreeNode expected = new TreeNode(7);
        expected.left = new TreeNode(9);
        expected.right = new TreeNode(4);
        expected.left.left = new TreeNode(10);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution538.convertBST(root)));
    }
}
