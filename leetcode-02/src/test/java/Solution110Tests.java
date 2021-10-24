import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution110Tests {
    private final Solution110 solution110 = new Solution110();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assertions.assertTrue(solution110.isBalanced(root));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        Assertions.assertFalse(solution110.isBalanced(root));
    }

    @Test
    public void example3() {
        TreeNode root = null;
        Assertions.assertTrue(solution110.isBalanced(root));
    }
}
