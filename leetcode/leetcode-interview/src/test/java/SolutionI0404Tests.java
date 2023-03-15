import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0404Tests {
    private final SolutionI0404 solutionI0404 = new SolutionI0404();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        Assertions.assertTrue(solutionI0404.isBalanced(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,2,3,3,null,null,4,4]");
        Assertions.assertFalse(solutionI0404.isBalanced(root));
    }
}
