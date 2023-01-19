import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution663Tests {
    private final Solution663 solution663 = new Solution663();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[5,10,10,null,null,2,3]");
        Assertions.assertTrue(solution663.checkEqualTree(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,10,null,null,2,20]");
        Assertions.assertFalse(solution663.checkEqualTree(root));
    }
}