import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3470Tests {
    private final Solution3470 solution3470 = new Solution3470();

    @Test
    public void example1() {
        int n = 4;
        long k = 6;
        int[] expected = {3, 4, 1, 2};
        Assertions.assertArrayEquals(expected, solution3470.permute(n, k));
    }

    @Test
    public void example2() {
        int n = 3;
        long k = 2;
        int[] expected = {3, 2, 1};
        Assertions.assertArrayEquals(expected, solution3470.permute(n, k));
    }

    @Test
    public void example3() {
        int n = 2;
        long k = 3;
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution3470.permute(n, k));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/permutations-iv/submissions/608196751/
        int n = 41;
        long k = 872502217664402L;
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 32, 21, 24, 33, 38, 31, 28, 37, 26, 27, 34, 23, 22, 29, 30, 25, 20, 35, 36, 41, 40, 39};
        Assertions.assertArrayEquals(expected, solution3470.permute(n, k));
    }
}