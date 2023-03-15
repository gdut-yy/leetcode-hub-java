import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1120Tests {
    private final Solution1120 solution1120 = new Solution1120();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,6,1]");
        double expected = 6.00000;
        Assertions.assertEquals(expected, solution1120.maximumAverageSubtree(root));
    }
}