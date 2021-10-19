import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution572Tests {
    private final Solution572 solution572 = new Solution572();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);
        Assertions.assertTrue(solution572.isSubtree(root, subRoot));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(0);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);
        Assertions.assertFalse(solution572.isSubtree(root, subRoot));
    }
}
