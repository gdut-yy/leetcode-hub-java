import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP67Tests {
    private final SolutionLCP67 solutionLCP67 = new SolutionLCP67();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[7,5,6]");
        TreeNode expected = TreeNode.buildTreeNode("[7,-1,-1,5,null,null,6]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionLCP67.expandBinaryTree(root)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,1,7,3,8,null,4]");
        TreeNode expected = TreeNode.buildTreeNode("[3,-1,-1,1,null,null,7,-1,-1,null,-1,3,null,null,8,null,4]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionLCP67.expandBinaryTree(root)));
    }
}
