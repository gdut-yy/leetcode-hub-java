import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution965Tests {
    private final Solution965 solution965 = new Solution965();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(1);
        Assertions.assertTrue(solution965.isUnivalTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);
        Assertions.assertFalse(solution965.isUnivalTree(root));
    }
}
