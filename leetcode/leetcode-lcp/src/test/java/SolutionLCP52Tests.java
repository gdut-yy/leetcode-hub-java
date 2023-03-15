import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP52Tests {
    private final SolutionLCP52 solutionLCP52 = new SolutionLCP52();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,2,null,3,null,4,null,5]");
        int[][] ops = UtUtils.stringToInts2("[[1,2,4],[1,1,3],[0,3,5]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP52.getNumber(root, ops));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,7,1,null,5,null,null,null,null,6]");
        int[][] ops = UtUtils.stringToInts2("[[0,2,2],[1,1,5],[0,4,5],[1,5,7]]");
        int expected = 5;
        Assertions.assertEquals(expected, solutionLCP52.getNumber(root, ops));
    }
}
