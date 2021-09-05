import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution437Tests {
    private final Solution437 solution437 = new Solution437();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.left = null;
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.left = null;
        root.left.right.right = new TreeNode(1);
        int targetSum = 8;
        int expected = 3;
        Assertions.assertEquals(expected, solution437.pathSum(root, targetSum));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.right = null;
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left.left = null;
        root.right.left.right = null;
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        int expected = 3;
        Assertions.assertEquals(expected, solution437.pathSum(root, targetSum));
    }
}
