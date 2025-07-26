import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution889Tests {
    private final Solution889 solution889 = new Solution889();

    @Test
    public void example1() {
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};
        TreeNode expected = TreeNode.buildTreeNode("[1,2,3,4,5,6,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution889.constructFromPrePost(preorder, postorder)));
    }

    @Test
    public void example2() {
        int[] preorder = {1};
        int[] postorder = {1};
        TreeNode expected = TreeNode.buildTreeNode("[1]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution889.constructFromPrePost(preorder, postorder)));
    }
}