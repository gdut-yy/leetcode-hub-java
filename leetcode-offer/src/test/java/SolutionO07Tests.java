import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO07Tests {
    private final SolutionO07 solutionO07 = new SolutionO07();

    @Test
    public void example1() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode expected = new TreeNode(3);
        expected.left = new TreeNode(9);
        expected.right = new TreeNode(20);
        expected.right.left = new TreeNode(15);
        expected.right.right = new TreeNode(7);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionO07.buildTree(preorder, inorder)));
    }

    @Test
    public void example2() {
        int[] preorder = {-1};
        int[] inorder = {-1};
        TreeNode expected = new TreeNode(-1);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionO07.buildTree(preorder, inorder)));
    }
}
