import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0412Tests {
    private final SolutionI0412 solutionI0412 = new SolutionI0412();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.right = null;
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left.left = null;
        root.right.left.right = null;
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        int targetSum = 22;
        int expected = 3;
        Assertions.assertEquals(expected, solutionI0412.pathSum(root, targetSum));
    }
}
