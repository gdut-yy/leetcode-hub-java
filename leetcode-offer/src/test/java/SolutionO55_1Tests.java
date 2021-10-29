import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO55_1Tests {
    private final SolutionO55_1 solutionO55_1 = new SolutionO55_1();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionO55_1.maxDepth(root));
    }
}
