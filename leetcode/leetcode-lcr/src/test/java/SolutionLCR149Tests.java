import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR149Tests {
    private final SolutionLCR149 solutionLCR149 = new SolutionLCR149();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        int[] expected = {3, 9, 20, 15, 7};
        Assertions.assertArrayEquals(expected, solutionLCR149.decorateRecord(root));
    }
}
