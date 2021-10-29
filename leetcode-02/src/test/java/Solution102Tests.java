import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution102Tests {
    private final Solution102 solution102 = new Solution102();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> expected = List.of(List.of(3), List.of(9, 20), List.of(15, 7));
        Assertions.assertEquals(expected, solution102.levelOrder(root));
    }
}
