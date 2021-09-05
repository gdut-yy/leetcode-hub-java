import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution124Tests {
    private final Solution124 solution124 = new Solution124();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int expected = 6;
        Assertions.assertEquals(expected, solution124.maxPathSum(root));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int expected = 42;
        Assertions.assertEquals(expected, solution124.maxPathSum(root));
    }
}
