import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionLCR150Tests {
    private final SolutionLCR150 solutionLCR150 = new SolutionLCR150();

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
        Assertions.assertEquals(expected, solutionLCR150.decorateRecord(root));
    }
}
