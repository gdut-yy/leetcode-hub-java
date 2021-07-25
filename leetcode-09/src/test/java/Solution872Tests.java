import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution872Tests {
    private final Solution872 solution872 = new Solution872();

    @Test
    public void example1() {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);
        Assertions.assertTrue(solution872.leafSimilar(root1, root2));
    }

    @Test
    public void example2() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        Assertions.assertTrue(solution872.leafSimilar(root1, root2));
    }

    @Test
    public void example3() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        Assertions.assertFalse(solution872.leafSimilar(root1, root2));
    }

    @Test
    public void example4() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(2);
        Assertions.assertTrue(solution872.leafSimilar(root1, root2));
    }

    @Test
    public void example5() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        Assertions.assertFalse(solution872.leafSimilar(root1, root2));
    }
}
