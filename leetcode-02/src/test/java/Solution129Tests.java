import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution129Tests {
    private final Solution129 solution129 = new Solution129();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int expected = 25;
        Assertions.assertEquals(expected, solution129.sumNumbers(root));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        int expected = 1026;
        Assertions.assertEquals(expected, solution129.sumNumbers(root));
    }
}
