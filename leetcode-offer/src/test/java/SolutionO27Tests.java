import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO27Tests {
    private final SolutionO27 solutionO27 = new SolutionO27();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        // expected
        TreeNode expected = new TreeNode(4);
        expected.left = new TreeNode(7);
        expected.right = new TreeNode(2);
        expected.left.left = new TreeNode(9);
        expected.left.right = new TreeNode(6);
        expected.right.left = new TreeNode(3);
        expected.right.right = new TreeNode(1);
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionO27.mirrorTree(root)));
    }
}
