import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR174Tests {
    private final SolutionLCR174 solutionLCR174 = new SolutionLCR174();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,1,4,null,2]");
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCR174.findTargetNode(root, k));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,3,6,2,4,null,null,1]");
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCR174.findTargetNode(root, k));
    }
}
