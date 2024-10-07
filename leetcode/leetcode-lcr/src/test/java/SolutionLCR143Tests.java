import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR143Tests {
    private final SolutionLCR143 solutionLCR143 = new SolutionLCR143();

    @Test
    public void example1() {
        TreeNode A = TreeNode.buildTreeNode("[1,2,3]");
        TreeNode B = TreeNode.buildTreeNode("[3,1]");
        Assertions.assertFalse(solutionLCR143.isSubStructure(A, B));
    }

    @Test
    public void example2() {
        TreeNode A = TreeNode.buildTreeNode("[3,4,5,1,2]");
        TreeNode B = TreeNode.buildTreeNode("[4,1]");
        Assertions.assertTrue(solutionLCR143.isSubStructure(A, B));
    }
}
