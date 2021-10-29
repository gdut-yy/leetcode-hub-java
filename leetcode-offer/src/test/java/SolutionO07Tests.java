import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO07Tests {
    private final SolutionO07 solutionO07 = new SolutionO07();

    @Test
    public void example1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = TreeNode.buildTreeNode("[3,9,20,null,null,15,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionO07.buildTree(preorder, inorder)));
    }

    @Test
    public void example2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = TreeNode.buildTreeNode("[-1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionO07.buildTree(preorder, inorder)));
    }
}
