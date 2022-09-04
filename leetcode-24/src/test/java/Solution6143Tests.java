import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6143Tests {
    private final Solution6143 solution6143 = new Solution6143();

    @Test
    public void example1() {
        int[] chargeTimes = {3, 6, 1, 3, 4};
        int[] runningCosts = {2, 1, 3, 4, 5};
        long budget = 25;
        int expected = 3;
        Assertions.assertEquals(expected, solution6143.maximumRobots(chargeTimes, runningCosts, budget));
    }

    @Test
    public void example2() {
        int[] chargeTimes = {11, 12, 19};
        int[] runningCosts = {10, 8, 7};
        long budget = 19;
        int expected = 0;
        Assertions.assertEquals(expected, solution6143.maximumRobots(chargeTimes, runningCosts, budget));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/358639358/
        // 子数组 非 子序列
        int[] chargeTimes = {8, 76, 74, 9, 75, 71, 71, 42, 15, 58, 88, 38, 56, 59, 10, 11};
        int[] runningCosts = {1, 92, 41, 63, 22, 37, 37, 8, 68, 97, 39, 59, 45, 50, 29, 37};
        long budget = 412;
        int expected = 3;
        Assertions.assertEquals(expected, solution6143.maximumRobots(chargeTimes, runningCosts, budget));
    }
}