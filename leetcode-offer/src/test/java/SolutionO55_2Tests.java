import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO55_2Tests {
    private final SolutionO55_2 solutionO55_2 = new SolutionO55_2();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        Assertions.assertTrue(solutionO55_2.isBalanced(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,2,3,3,null,null,4,4]");
        Assertions.assertFalse(solutionO55_2.isBalanced(root));
    }
}
