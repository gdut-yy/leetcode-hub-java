import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6052Tests {
    private final Solution6052 solution6052 = new Solution6052();

    @Test
    public void example1() {
        int[] nums = {2, 5, 3, 9, 5, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution6052.minimumAverageDifference(nums));
    }

    @Test
    public void example2() {
        int[] nums = {0};
        int expected = 0;
        Assertions.assertEquals(expected, solution6052.minimumAverageDifference(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode-cn.com/submissions/detail/307520580/
        // / zero
        int[] nums = {4, 2, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solution6052.minimumAverageDifference(nums));
    }
}
