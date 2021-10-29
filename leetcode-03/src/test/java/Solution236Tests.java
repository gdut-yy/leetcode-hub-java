import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution236Tests {
    private final Solution236 solution236 = new Solution236();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution236.lowestCommonAncestor(root, p, q)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(4);
        TreeNode expected = root.left;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution236.lowestCommonAncestor(root, p, q)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2]");
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(2);
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution236.lowestCommonAncestor(root, p, q)));
    }
}
