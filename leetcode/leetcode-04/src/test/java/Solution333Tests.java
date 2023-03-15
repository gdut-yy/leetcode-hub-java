import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution333Tests {
    private final Solution333 solution333 = new Solution333();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[10,5,15,1,8,null,7]");
        int expected = 3;
        Assertions.assertEquals(expected, solution333.largestBSTSubtree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[4,2,7,2,3,5,null,2,null,null,null,null,null,1]");
        int expected = 2;
        Assertions.assertEquals(expected, solution333.largestBSTSubtree(root));
    }
}
