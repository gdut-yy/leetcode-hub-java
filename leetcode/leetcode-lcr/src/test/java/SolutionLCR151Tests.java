import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionLCR151Tests {
    private final SolutionLCR151 solutionLCR151 = new SolutionLCR151();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("""
                [
                  [3],
                  [20,9],
                  [15,7]
                ]
                """);
        Assertions.assertEquals(expected, solutionLCR151.decorateRecord(root));
    }
}
