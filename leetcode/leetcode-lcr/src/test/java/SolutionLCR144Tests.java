import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR144Tests {
    private final SolutionLCR144 solutionLCR144 = new SolutionLCR144();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,7,1,3,6,9]");
        TreeNode expected = TreeNode.buildTreeNode("[4,7,2,9,6,3,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionLCR144.mirrorTree(root)));
    }
}
