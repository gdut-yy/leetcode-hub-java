import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionO32_2Tests {
    private final SolutionO32_2 solutionO32_2 = new SolutionO32_2();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [
                  [3],
                  [9,20],
                  [15,7]
                ]
                """);
        Assertions.assertEquals(expected, solutionO32_2.levelOrder(root));
    }
}
