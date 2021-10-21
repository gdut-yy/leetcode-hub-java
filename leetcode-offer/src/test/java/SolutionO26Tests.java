import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO26Tests {
    private final SolutionO26 solutionO26 = new SolutionO26();

    @Test
    public void example1() {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);

        TreeNode B = new TreeNode(3);
        B.left = new TreeNode(1);

        Assertions.assertFalse(solutionO26.isSubStructure(A, B));
    }

    @Test
    public void example2() {
        TreeNode A = new TreeNode(3);
        A.left = new TreeNode(4);
        A.right = new TreeNode(5);
        A.left.left = new TreeNode(1);
        A.left.right = new TreeNode(2);

        TreeNode B = new TreeNode(4);
        B.left = new TreeNode(1);

        Assertions.assertTrue(solutionO26.isSubStructure(A, B));
    }
}
