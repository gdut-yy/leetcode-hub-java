import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution536Tests {
    private final Solution536 solution536 = new Solution536();

    @Test
    public void example1() {
        String s = "4(2(3)(1))(6(5))";
        TreeNode expected = TreeNode.buildTreeNode("[4,2,6,3,1,5]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution536.str2tree(s)));
    }

    @Test
    public void example2() {
        String s = "4(2(3)(1))(6(5)(7))";
        TreeNode expected = TreeNode.buildTreeNode("[4,2,6,3,1,5,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution536.str2tree(s)));
    }

    @Test
    public void example3() {
        String s = "-4(2(3)(1))(6(5)(7))";
        TreeNode expected = TreeNode.buildTreeNode("[-4,2,6,3,1,5,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution536.str2tree(s)));
    }
}
