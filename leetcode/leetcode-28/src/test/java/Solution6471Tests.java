import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6471Tests {
    private final Solution6471 solution6471 = new Solution6471();

    @Test
    public void example1() {
        int num1 = 3;
        int num2 = -2;
        int expected = 3;
        Assertions.assertEquals(expected, solution6471.makeTheIntegerZero(num1, num2));
    }

    @Test
    public void example2() {
        int num1 = 5;
        int num2 = 7;
        int expected = -1;
        Assertions.assertEquals(expected, solution6471.makeTheIntegerZero(num1, num2));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/441953882/
        // BFS TLE
        int num1 = 16245;
        int num2 = -88727;
        int expected = 12;
        Assertions.assertEquals(expected, solution6471.makeTheIntegerZero(num1, num2));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/441953882/
        // 536 / 537 个通过测试用例
        int num1 = 85;
        int num2 = 42;
        int expected = -1;
        Assertions.assertEquals(expected, solution6471.makeTheIntegerZero(num1, num2));
    }
}