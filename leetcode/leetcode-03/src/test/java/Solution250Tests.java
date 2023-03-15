import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution250Tests {
    private final Solution250 solution250 = new Solution250();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,1,5,5,5,null,5]");
        int expected = 4;
        Assertions.assertEquals(expected, solution250.countUnivalSubtrees(root));
    }
}
