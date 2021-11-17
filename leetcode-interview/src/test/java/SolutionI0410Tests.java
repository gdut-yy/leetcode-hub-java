import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0410Tests {
    private final SolutionI0410 solutionI0410 = new SolutionI0410();

    @Test
    public void example1() {
        TreeNode t1 = TreeNode.buildTreeNode("[1,2,3]");
        TreeNode t2 = TreeNode.buildTreeNode("[2]");
        Assertions.assertTrue(solutionI0410.checkSubTree(t1, t2));
    }

    @Test
    public void example2() {
        TreeNode t1 = TreeNode.buildTreeNode("[1,null,2,4]");
        TreeNode t2 = TreeNode.buildTreeNode("[3,2]");
        Assertions.assertFalse(solutionI0410.checkSubTree(t1, t2));
    }
}
