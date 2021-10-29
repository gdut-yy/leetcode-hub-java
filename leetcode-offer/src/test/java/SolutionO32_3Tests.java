import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionO32_3Tests {
    private final SolutionO32_3 solutionO32_3 = new SolutionO32_3();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> expected = List.of(List.of(3), List.of(20, 9), List.of(15, 7));
        Assertions.assertEquals(expected, solutionO32_3.levelOrder(root));
    }
}
