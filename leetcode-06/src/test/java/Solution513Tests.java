import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution513Tests {
    private final Solution513 solution513 = new Solution513();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        int expected = 1;
        Assertions.assertEquals(expected, solution513.findBottomLeftValue(root));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        int expected = 7;
        Assertions.assertEquals(expected, solution513.findBottomLeftValue(root));
    }
}
