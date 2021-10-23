import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO54Tests {
    private final SolutionO54 solutionO54 = new SolutionO54();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solutionO54.kthLargest(root, k));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solutionO54.kthLargest(root, k));
    }
}
