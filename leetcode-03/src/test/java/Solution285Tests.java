import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution285Tests {
    private final Solution285 solution285 = new Solution285();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[2,1,3]");
        TreeNode p = new TreeNode(1);
        TreeNode expected = root;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution285.inorderSuccessor(root, p)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,3,6,2,4,null,null,1]");
        TreeNode p = new TreeNode(6);
        TreeNode expected = null;
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution285.inorderSuccessor(root, p)));
    }
}
