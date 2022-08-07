import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6137Tests {
    private final Solution6137 solution6137 = new Solution6137();

    @Test
    public void example1() {
        int[] nums = {4, 4, 4, 5, 6};
        Assertions.assertTrue(solution6137.validPartition(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 2};
        Assertions.assertFalse(solution6137.validPartition(nums));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/346938101/
        // 54 / 112 个通过测试用例 TLE
        int[] nums = UtUtils.loadingInts("solution6137-example3-input.txt", 0);
        Assertions.assertFalse(solution6137.validPartition(nums));
    }
}
