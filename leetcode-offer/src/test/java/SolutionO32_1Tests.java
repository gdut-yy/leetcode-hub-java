import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO32_1Tests {
    private final SolutionO32_1 solutionO32_1 = new SolutionO32_1();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int[] expected = {3, 9, 20, 15, 7};
        Assertions.assertArrayEquals(expected, solutionO32_1.levelOrder(root));
    }
}
