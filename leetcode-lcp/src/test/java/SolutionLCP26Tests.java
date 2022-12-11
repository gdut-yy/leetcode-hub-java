import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP26Tests {
    private final SolutionLCP26 solutionLCP26 = new SolutionLCP26();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,null,3,4]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP26.navigation(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP26.navigation(root));
    }
}
