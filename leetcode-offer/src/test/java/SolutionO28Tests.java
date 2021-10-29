import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO28Tests {
    private final SolutionO28 solutionO28 = new SolutionO28();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,2,3,4,4,3]");
        Assertions.assertTrue(solutionO28.isSymmetric(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,2,null,3,null,3]");
        Assertions.assertFalse(solutionO28.isSymmetric(root));
    }
}
