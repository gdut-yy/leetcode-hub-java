import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution104Tests {
    private final Solution104 solution104 = new Solution104();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int expected = 3;
        Assertions.assertEquals(expected, solution104.maxDepth(root));
    }
}
