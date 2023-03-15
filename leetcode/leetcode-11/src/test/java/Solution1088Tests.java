import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1088Tests {
    private final Solution1088 solution1088 = new Solution1088();

    @Test
    public void example1() {
        int n = 20;
        int expected = 6;
        Assertions.assertEquals(expected, solution1088.confusingNumberII(n));
    }

    @Test
    public void example2() {
        int n = 100;
        int expected = 19;
        Assertions.assertEquals(expected, solution1088.confusingNumberII(n));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/396708705/
        // java.lang.StackOverflowError
        int n = 1000000000;
        int expected = 1950627;
        Assertions.assertEquals(expected, solution1088.confusingNumberII(n));
    }
}