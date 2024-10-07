import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR176Tests {
    private final SolutionLCR176 solutionLCR176 = new SolutionLCR176();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        Assertions.assertTrue(solutionLCR176.isBalanced(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,2,3,3,null,null,4,4]");
        Assertions.assertFalse(solutionLCR176.isBalanced(root));
    }
}
