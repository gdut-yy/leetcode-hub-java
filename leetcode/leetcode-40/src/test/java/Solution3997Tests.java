import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3997Tests {
    private final Solution3997 solution3997 = new Solution3997();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,3,8,2,4,7,1]");
        int expected = 5;
        Assertions.assertEquals(expected, solution3997.countDominantNodes(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,1,2]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3997.countDominantNodes(root));
    }
}