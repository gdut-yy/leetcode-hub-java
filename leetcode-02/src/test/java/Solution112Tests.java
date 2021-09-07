import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution112Tests {
    private final Solution112 solution112 = new Solution112();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        Assertions.assertTrue(solution112.hasPathSum(root, targetSum));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int targetSum = 5;
        Assertions.assertFalse(solution112.hasPathSum(root, targetSum));
    }

    @Test
    public void example3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        int targetSum = 0;
        Assertions.assertFalse(solution112.hasPathSum(root, targetSum));
    }
}
