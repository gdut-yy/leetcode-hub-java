import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO27Tests {
    private final SolutionO27 solutionO27 = new SolutionO27();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,7,1,3,6,9]");
        TreeNode expected = TreeNode.buildTreeNode("[4,7,2,9,6,3,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionO27.mirrorTree(root)));
    }
}
