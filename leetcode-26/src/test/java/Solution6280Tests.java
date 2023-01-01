import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6280Tests {
    private final Solution6280 solution6280 = new Solution6280();

    @Test
    public void example1() {
        int left = 10;
        int right = 19;
        int[] expected = {11, 13};
        Assertions.assertArrayEquals(expected, solution6280.closestPrimes(left, right));
    }

    @Test
    public void example2() {
        int left = 4;
        int right = 6;
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution6280.closestPrimes(left, right));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/392191399/
        int left = 19;
        int right = 31;
        int[] expected = {29, 31};
        Assertions.assertArrayEquals(expected, solution6280.closestPrimes(left, right));
    }
}
