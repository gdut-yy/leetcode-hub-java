import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP44Tests {
    private final SolutionLCP44 solutionLCP44 = new SolutionLCP44();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,2,1,null,2]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP44.numColor(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,3,3]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP44.numColor(root));
    }
}
