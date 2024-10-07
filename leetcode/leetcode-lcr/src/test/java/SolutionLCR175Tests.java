import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR175Tests {
    private final SolutionLCR175 solutionLCR175 = new SolutionLCR175();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCR175.calculateDepth(root));
    }
}
