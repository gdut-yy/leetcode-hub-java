import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1973Tests {
    private final Solution1973 solution1973 = new Solution1973();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[10,3,4,2,1]");
        int expected = 2;
        Assertions.assertEquals(expected, solution1973.equalToDescendants(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[2,3,null,2,null]");
        int expected = 0;
        Assertions.assertEquals(expected, solution1973.equalToDescendants(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[0]");
        int expected = 1;
        Assertions.assertEquals(expected, solution1973.equalToDescendants(root));
    }
}