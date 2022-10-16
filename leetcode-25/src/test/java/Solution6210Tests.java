import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6210Tests {
    private final Solution6210 solution6210 = new Solution6210();

    @Test
    public void example1() {
        int[] nums = {3, 7, 1, 6};
        int expected = 5;
        Assertions.assertEquals(expected, solution6210.minimizeArrayValue(nums));
        Assertions.assertEquals(expected, solution6210.minimizeArrayValue2(nums));
    }

    @Test
    public void example2() {
        int[] nums = {10, 1};
        int expected = 10;
        Assertions.assertEquals(expected, solution6210.minimizeArrayValue(nums));
        Assertions.assertEquals(expected, solution6210.minimizeArrayValue2(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/373487890/
        // 爆 int
        int[] nums = UtUtils.loadingInts("solution6210-example3-input.txt", 0);
        int expected = 536251085;
        Assertions.assertEquals(expected, solution6210.minimizeArrayValue(nums));
        Assertions.assertEquals(expected, solution6210.minimizeArrayValue2(nums));
    }
}
