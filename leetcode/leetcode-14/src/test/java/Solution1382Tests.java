import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1382Tests {
    private final Solution1382 solution1382 = new Solution1382();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,null,2,null,3,null,4,null,null]");
        TreeNode expected = TreeNode.buildTreeNode("[2,1,3,null,null,null,4]");
        // 这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1382.balanceBST(root)));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,1,3]");
        TreeNode expected = TreeNode.buildTreeNode("[2,1,3]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1382.balanceBST(root)));
    }
}