import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR145Tests {
    private final SolutionLCR145 solutionLCR145 = new SolutionLCR145();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,2,3,4,4,3]");
        Assertions.assertTrue(solutionLCR145.checkSymmetricTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,2,null,3,null,3]");
        Assertions.assertFalse(solutionLCR145.checkSymmetricTree(root));
    }
}
