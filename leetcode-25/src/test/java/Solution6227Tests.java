import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6227Tests {
    private final Solution6227 solution6227 = new Solution6227();

    @Test
    public void example1() {
        int[] nums = {2, 4, 0, 9, 6};
        int[] expected = {9, 6, 6, -1, -1};
        Assertions.assertArrayEquals(expected, solution6227.secondGreaterElement(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 3};
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution6227.secondGreaterElement(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/377644778/ TLE
        int[] nums = UtUtils.loadingInts("solution6227-example3-input.txt", 0);
        int[] expected = UtUtils.loadingInts("solution6227-example3-output.txt", 0);
        Assertions.assertArrayEquals(expected, solution6227.secondGreaterElement(nums));
    }
}
