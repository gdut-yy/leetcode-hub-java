import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO55_1Tests {
    private final SolutionO55_1 solutionO55_1 = new SolutionO55_1();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int expected = 3;
        Assertions.assertEquals(expected, solutionO55_1.maxDepth(root));
    }
}
