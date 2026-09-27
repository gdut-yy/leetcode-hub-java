import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3879Tests {
    private final SolutionP3879 solutionP3879 = new SolutionP3879();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[2,2,1]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3879.maxSum(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,-2,5,null,null,3,5]");
        int expected = 9;
        Assertions.assertEquals(expected, solutionP3879.maxSum(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[4,6,6,null,null,null,9]");
        int expected = 19;
        Assertions.assertEquals(expected, solutionP3879.maxSum(root));
    }
}
