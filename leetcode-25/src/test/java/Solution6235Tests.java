import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6235Tests {
    private final Solution6235 solution6235 = new Solution6235();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,4,3,7,6,8,5,null,null,null,null,9,null,10]");
        int expected = 3;
        Assertions.assertEquals(expected, solution6235.minimumOperations(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,2,7,6,5,4]");
        int expected = 3;
        Assertions.assertEquals(expected, solution6235.minimumOperations(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,5,6]");
        int expected = 0;
        Assertions.assertEquals(expected, solution6235.minimumOperations(root));
    }
}
