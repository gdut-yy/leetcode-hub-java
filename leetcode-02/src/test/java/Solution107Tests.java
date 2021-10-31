import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution107Tests {
    private final Solution107 solution107 = new Solution107();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> expected = List.of(List.of(15, 7), List.of(9, 20), List.of(3));
        Assertions.assertEquals(expected, solution107.levelOrderBottom(root));
    }
}
