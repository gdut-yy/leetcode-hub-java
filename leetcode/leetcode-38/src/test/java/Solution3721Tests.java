import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3721Tests {
    private final Solution3721 solution3721 = new Solution3721();

    @Test
    public void example1() {
        int[] nums = {2, 5, 4, 3};
        int expected = 4;
        Assertions.assertEquals(expected, solution3721.longestBalanced(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 2, 5, 4};
        int expected = 5;
        Assertions.assertEquals(expected, solution3721.longestBalanced(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 2};
        int expected = 3;
        Assertions.assertEquals(expected, solution3721.longestBalanced(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/longest-balanced-subarray-ii/submissions/671829121/
        int[] nums = {34267};
        int expected = 0;
        Assertions.assertEquals(expected, solution3721.longestBalanced(nums));
    }
}