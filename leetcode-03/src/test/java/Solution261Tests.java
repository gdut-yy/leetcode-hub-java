import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution261Tests {
    private final Solution261 solution261 = new Solution261();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[1,4]]");
        Assertions.assertTrue(solution261.validTree(n, edges));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,3],[1,3],[1,4]]");
        Assertions.assertFalse(solution261.validTree(n, edges));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/282658329/
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[2,3]]");
        Assertions.assertFalse(solution261.validTree(n, edges));
    }
}