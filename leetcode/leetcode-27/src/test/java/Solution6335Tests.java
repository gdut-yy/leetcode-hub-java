import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6335Tests {
    private final Solution6335 solution6335 = new Solution6335();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,4,9,1,10,null,7]");
        TreeNode expected = TreeNode.buildTreeNode("[0,0,0,7,7,null,11]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution6335.replaceValueInTree(root)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[3,1,2]");
        TreeNode expected = TreeNode.buildTreeNode("[0,0,0]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution6335.replaceValueInTree(root)));
    }
}