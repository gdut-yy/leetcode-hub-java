import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100Tests {
    private final Solution100 solution100 = new Solution100();

    @Test
    public void example1() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        Assertions.assertTrue(solution100.isSameTree(p, q));
    }

    @Test
    public void example2() {
        TreeNode p = new TreeNode(1, new TreeNode(2), null);
        TreeNode q = new TreeNode(1, null, new TreeNode(2));
        Assertions.assertFalse(solution100.isSameTree(p, q));
    }

    @Test
    public void example3() {
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q = new TreeNode(1, new TreeNode(1), new TreeNode(3));
        Assertions.assertFalse(solution100.isSameTree(p, q));
    }
}
