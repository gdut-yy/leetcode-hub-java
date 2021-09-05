import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution285Tests {
    private final Solution285 solution285 = new Solution285();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode p = new TreeNode(1);
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution285.inorderSuccessor(root, p)));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        TreeNode p = new TreeNode(6);
        TreeNode expected = null;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution285.inorderSuccessor(root, p)));
    }
}
