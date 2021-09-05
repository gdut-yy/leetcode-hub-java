import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution653Tests {
    private final Solution653 solution653 = new Solution653();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        int k = 9;
        Assertions.assertTrue(solution653.findTarget(root, k));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        int k = 28;
        Assertions.assertFalse(solution653.findTarget(root, k));
    }

    @Test
    public void example3() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        int k = 4;
        Assertions.assertTrue(solution653.findTarget(root, k));
    }

    @Test
    public void example4() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        int k = 1;
        Assertions.assertFalse(solution653.findTarget(root, k));
    }

    @Test
    public void example5() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        int k = 3;
        Assertions.assertTrue(solution653.findTarget(root, k));
    }
}
