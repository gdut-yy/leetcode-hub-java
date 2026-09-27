import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP3902Tests {
    private final SolutionP3902 solutionP3902 = new SolutionP3902();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,2,8,1,null,9,6]");
        List<Long> expected = List.of(5L, 8L, 0L);
        Assertions.assertEquals(expected, solutionP3902.zigzagLevelSum(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,null,7]");
        List<Long> expected = List.of(1L, 5L, 0L);
        Assertions.assertEquals(expected, solutionP3902.zigzagLevelSum(root));
    }
}
