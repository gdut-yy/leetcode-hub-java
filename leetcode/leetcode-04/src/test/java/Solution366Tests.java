import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution366Tests {
    private final Solution366 solution366 = new Solution366();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[4,5,3],[2],[1]]");
        Assertions.assertEquals(expected, solution366.findLeaves(root));
    }
}
