import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution236Tests {
    private final Solution236 solution236 = new Solution236();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution236.lowestCommonAncestor(root, p, q)));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode expected = root.left;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution236.lowestCommonAncestor(root, p, q)));
    }
}
