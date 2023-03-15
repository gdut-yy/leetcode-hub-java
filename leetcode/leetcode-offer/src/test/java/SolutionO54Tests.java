import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO54Tests {
    private final SolutionO54 solutionO54 = new SolutionO54();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,1,4,null,2]");
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solutionO54.kthLargest(root, k));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,3,6,2,4,null,null,1]");
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solutionO54.kthLargest(root, k));
    }
}
