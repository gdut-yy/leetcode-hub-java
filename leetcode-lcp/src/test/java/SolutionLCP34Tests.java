import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP34Tests {
    private final SolutionLCP34 solutionLCP34 = new SolutionLCP34();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,2,3,4]");
        int k = 2;
        int expected = 12;
        Assertions.assertEquals(expected, solutionLCP34.maxValue(root, k));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[4,1,3,9,null,null,2]");
        int k = 2;
        int expected = 16;
        Assertions.assertEquals(expected, solutionLCP34.maxValue(root, k));
    }
}
