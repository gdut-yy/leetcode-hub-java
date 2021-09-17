import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution98Tests {
    private final Solution98 solution98 = new Solution98();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        Assertions.assertTrue(solution98.isValidBST(root));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        Assertions.assertFalse(solution98.isValidBST(root));
    }
}
