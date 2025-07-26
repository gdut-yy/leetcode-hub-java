import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1008Tests {
    private final Solution1008 solution1008 = new Solution1008();

    @Test
    public void example1() {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        TreeNode expected = TreeNode.buildTreeNode("[8,5,10,1,7,null,12]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1008.bstFromPreorder(preorder)));
    }

    @Test
    public void example2() {
        int[] preorder = {1, 3};
        TreeNode expected = TreeNode.buildTreeNode("[1,null,3]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1008.bstFromPreorder(preorder)));
    }
}