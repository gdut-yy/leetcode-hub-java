import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1228Tests {
    private final Solution1228 solution1228 = new Solution1228();

    @Test
    public void example1() {
        int[] arr = {5, 7, 11, 13};
        int expected = 9;
        Assertions.assertEquals(expected, solution1228.missingNumber(arr));
    }

    @Test
    public void example2() {
        int[] arr = {15, 13, 12};
        int expected = 14;
        Assertions.assertEquals(expected, solution1228.missingNumber(arr));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/396157152/
        // 公差为 0
        int[] arr = {0, 0, 0, 0, 0};
        int expected = 0;
        Assertions.assertEquals(expected, solution1228.missingNumber(arr));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/396157210/
        // 公差为负数，不能取最小值
        int[] arr = {80387, 68178, 55969, 31551};
        int expected = 43760;
        Assertions.assertEquals(expected, solution1228.missingNumber(arr));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/396157210/
        // 公差为 0
        int[] arr = {1, 1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1228.missingNumber(arr));
    }
}