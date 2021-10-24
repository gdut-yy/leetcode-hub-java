import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO55_2Tests {
    private final SolutionO55_2 solutionO55_2 = new SolutionO55_2();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assertions.assertTrue(solutionO55_2.isBalanced(root));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        Assertions.assertFalse(solutionO55_2.isBalanced(root));
    }
}
