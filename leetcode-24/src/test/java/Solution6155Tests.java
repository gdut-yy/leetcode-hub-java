import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6155Tests {
    private final Solution6155 solution6155 = new Solution6155();

    @Test
    public void example1() {
        int[] nums = {2, 4, -2};
        int k = 5;
        long expected = 2;
        Assertions.assertEquals(expected, solution6155.kSum(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, -2, 3, 4, -10, 12};
        int k = 16;
        long expected = 10;
        Assertions.assertEquals(expected, solution6155.kSum(nums, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/352948459/
        int[] nums = {-530219056, 353285209, 493533664};
        int k = 6;
        long expected = -36685392;
        Assertions.assertEquals(expected, solution6155.kSum(nums, k));
    }
}