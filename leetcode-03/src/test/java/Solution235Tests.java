import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution235Tests {
    private final Solution235 solution235 = new Solution235();

    @Test
    public void example1() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution235.lowestCommonAncestor(root, p, q)));
    }

    @Test
    public void example2() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(4);
        TreeNode expected = root.left;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution235.lowestCommonAncestor(root, p, q)));
    }
}
