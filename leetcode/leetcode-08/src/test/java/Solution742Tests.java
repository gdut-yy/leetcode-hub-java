import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution742Tests {
    private final Solution742 solution742 = new Solution742();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[1,3,2]");
        int k = 1;
        // 解释： 2 和 3 都是距离目标 1 最近的叶节点。
//        int expected = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution742.findClosestLeaf(root, k));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[1]");
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution742.findClosestLeaf(root, k));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[1,2,3,4,null,null,null,5,null,6]");
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution742.findClosestLeaf(root, k));
    }
}