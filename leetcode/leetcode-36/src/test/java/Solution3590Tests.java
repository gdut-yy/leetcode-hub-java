import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3590Tests {
    private final Solution3590.V1 solution3590_v1 = new Solution3590.V1();
    private final Solution3590.V2 solution3590_v2 = new Solution3590.V2();

    @Test
    public void example1() {
        int[] par = {-1, 0, 0};
        int[] vals = {1, 1, 1};
        int[][] queries = UtUtils.stringToInts2("[[0,1],[0,2],[0,3]]");
        int[] expected = {0, 1, -1};
        Assertions.assertArrayEquals(expected, solution3590_v1.kthSmallest(par, vals, queries));
        Assertions.assertArrayEquals(expected, solution3590_v2.kthSmallest(par, vals, queries));
    }

    @Test
    public void example2() {
        int[] par = {-1, 0, 1};
        int[] vals = {5, 2, 7};
        int[][] queries = UtUtils.stringToInts2("[[0,1],[1,2],[1,3],[2,1]]");
        int[] expected = {0, 7, -1, 0};
        Assertions.assertArrayEquals(expected, solution3590_v1.kthSmallest(par, vals, queries));
        Assertions.assertArrayEquals(expected, solution3590_v2.kthSmallest(par, vals, queries));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/problems/kth-smallest-path-xor-sum/submissions/638269805/
        int[] par = {-1, 2, 0};
        int[] vals = {32811, 41993, 5879};
        int[][] queries = UtUtils.stringToInts2("[[0,1]]");
        int[] expected = {13013};
        Assertions.assertArrayEquals(expected, solution3590_v1.kthSmallest(par, vals, queries));
        Assertions.assertArrayEquals(expected, solution3590_v2.kthSmallest(par, vals, queries));
    }
}