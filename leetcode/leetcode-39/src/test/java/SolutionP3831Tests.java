import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3831Tests {
    private final SolutionP3831 solutionP3831 = new SolutionP3831();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,null,5,null,7]");
        int level = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solutionP3831.levelMedian(root, level));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[6,3,8]");
        int level = 1;
        int expected = 8;
        Assertions.assertEquals(expected, solutionP3831.levelMedian(root, level));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[2,1]");
        int level = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solutionP3831.levelMedian(root, level));
    }
}
