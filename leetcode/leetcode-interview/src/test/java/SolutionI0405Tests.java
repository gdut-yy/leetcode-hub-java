import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0405Tests {
    private final SolutionI0405 solutionI0405 = new SolutionI0405();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[2,1,3]");
        Assertions.assertTrue(solutionI0405.isValidBST(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,1,4,null,null,3,6]");
        Assertions.assertFalse(solutionI0405.isValidBST(root));
    }
}
