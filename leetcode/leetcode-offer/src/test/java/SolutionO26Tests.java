import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO26Tests {
    private final SolutionO26 solutionO26 = new SolutionO26();

    @Test
    public void example1() {
        TreeNode A = TreeNode.buildTreeNode("[1,2,3]");
        TreeNode B = TreeNode.buildTreeNode("[3,1]");
        Assertions.assertFalse(solutionO26.isSubStructure(A, B));
    }

    @Test
    public void example2() {
        TreeNode A = TreeNode.buildTreeNode("[3,4,5,1,2]");
        TreeNode B = TreeNode.buildTreeNode("[4,1]");
        Assertions.assertTrue(solutionO26.isSubStructure(A, B));
    }
}
