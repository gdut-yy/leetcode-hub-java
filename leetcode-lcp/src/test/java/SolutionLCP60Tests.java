import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP60Tests {
    private final SolutionLCP60 solutionLCP60 = new SolutionLCP60();

    @Test
    public void example1() {
        TreeNode root = TreeNode.buildTreeNode("[6,0,3,null,8]");
        int expected = 11;
        Assertions.assertEquals(expected, solutionLCP60.getMaxLayerSum(root));
    }

    @Test
    public void example2() {
        TreeNode root = TreeNode.buildTreeNode("[5,6,2,4,null,null,1,3,5]");
        int expected = 9;
        Assertions.assertEquals(expected, solutionLCP60.getMaxLayerSum(root));
    }

    @Test
    public void example3() {
        TreeNode root = TreeNode.buildTreeNode("[-5,1,7]");
        int expected = 8;
        Assertions.assertEquals(expected, solutionLCP60.getMaxLayerSum(root));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/395232789/
        // LinkedList 性能问题
        TreeNode root = TreeNode.buildTreeNode(UtUtils.loadingString("lcp/60/example4.txt", 0));
        int expected = 527122;
        Assertions.assertEquals(expected, solutionLCP60.getMaxLayerSum(root));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/395243402/
        // TsReaper https://leetcode.cn/problems/WInSav/solution/by-tsreaper-5mrh/
        // TLE
        TreeNode root = TreeNode.buildTreeNode(UtUtils.loadingString("lcp/60/example5.txt", 0));
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP60.getMaxLayerSum(root));
    }
}
