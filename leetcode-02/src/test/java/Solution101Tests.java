import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution101Tests {
    private final Solution101 solution101 = new Solution101();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        Assertions.assertTrue(solution101.isSymmetric(root));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        Assertions.assertFalse(solution101.isSymmetric(root));
    }
}
