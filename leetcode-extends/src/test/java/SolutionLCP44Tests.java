import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP44Tests {
    private final SolutionLCP44 solutionLCP44 = new SolutionLCP44();

    @Test
    public void example1() {
        // root = [1,3,2,1,null,2]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(2);
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP44.numColor(root));
    }

    @Test
    public void example2() {
        // root = [3,3,3]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP44.numColor(root));
    }
}
