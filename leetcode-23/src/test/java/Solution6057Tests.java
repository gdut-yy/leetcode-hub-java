import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6057Tests {
    private final Solution6057 solution6057 = new Solution6057();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[4,8,5,0,1,null,6]");
        int expected = 5;
        Assertions.assertEquals(expected, solution6057.averageOfSubtree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        int expected = 1;
        Assertions.assertEquals(expected, solution6057.averageOfSubtree(root));
    }
}
