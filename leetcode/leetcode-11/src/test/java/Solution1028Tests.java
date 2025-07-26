import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1028Tests {
    private final Solution1028 solution1028 = new Solution1028();

    @Test
    public void example1() {
        String traversal = "1-2--3--4-5--6--7";
        TreeNode expected = TreeNode.buildTreeNode("[1,2,5,3,4,6,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1028.recoverFromPreorder(traversal)));
    }

    @Test
    public void example2() {
        String traversal = "1-2--3---4-5--6---7";
        TreeNode expected = TreeNode.buildTreeNode("[1,2,5,3,null,6,null,4,null,7]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1028.recoverFromPreorder(traversal)));
    }

    @Test
    public void example3() {
        String traversal = "1-401--349---90--88";
        TreeNode expected = TreeNode.buildTreeNode("[1,401,null,349,88,90]");
        Assertions.assertTrue(TreeNode.assertTreeNodeEquals(expected, solution1028.recoverFromPreorder(traversal)));
    }
}