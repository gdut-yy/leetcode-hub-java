import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution549Tests {
    private final Solution549 solution549 = new Solution549();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3]");
        int expected = 2;
        Assertions.assertEquals(expected, solution549.longestConsecutive(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,1,3]");
        int expected = 3;
        Assertions.assertEquals(expected, solution549.longestConsecutive(root));
    }
}
