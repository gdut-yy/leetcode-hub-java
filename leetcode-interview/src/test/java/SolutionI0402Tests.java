import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0402Tests {
    private final SolutionI0402 solutionI0402 = new SolutionI0402();

    @Test
    public void example1() {
        int[] nums = {-10, -3, 0, 5, 9};
        // 一个可能的答案是：[0,-3,9,-10,null,5]，
//        TreeNode expected = TreeNode.buildTreeNode("[0,-3,9,-10,null,5]");
        TreeNode expected = TreeNode.buildTreeNode("[0,-10,5,null,-3,null,9]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solutionI0402.sortedArrayToBST(nums)));
    }
}
