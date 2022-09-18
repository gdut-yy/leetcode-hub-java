import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6182Tests {
    private final Solution6182 solution6182 = new Solution6182();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[2,3,5,8,13,21,34]");
        TreeNode expected = TreeNode.buildTreeNode("[2,5,3,8,13,21,34]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution6182.reverseOddLevels(root)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[7,13,11]");
        TreeNode expected = TreeNode.buildTreeNode("[7,11,13]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution6182.reverseOddLevels(root)));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]");
        TreeNode expected = TreeNode.buildTreeNode("[0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution6182.reverseOddLevels(root)));
    }
}
