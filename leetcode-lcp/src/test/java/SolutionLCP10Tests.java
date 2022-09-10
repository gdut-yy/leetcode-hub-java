import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP10Tests {
    private final SolutionLCP10 solutionLCP10 = new SolutionLCP10();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[47,74,31]");
        double expected = 121;
        Assertions.assertEquals(expected, solutionLCP10.minimalExecTime(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[15,21,null,24,null,27,26]");
        double expected = 87;
        Assertions.assertEquals(expected, solutionLCP10.minimalExecTime(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,2,null,null,4,4]");
        double expected = 7.5;
        Assertions.assertEquals(expected, solutionLCP10.minimalExecTime(root));
    }
}
