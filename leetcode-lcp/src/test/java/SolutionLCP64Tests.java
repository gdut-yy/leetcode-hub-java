import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP64Tests {
    private final SolutionLCP64 solutionLCP64 = new SolutionLCP64();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,1,0,null,null,null,1]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP64.closeLampInTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,1,1,1,null,null,1]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP64.closeLampInTree(root));
    }
}
