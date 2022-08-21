import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6166Tests {
    private final Solution6166 solution6166 = new Solution6166();

    @Test
    public void example1() {
        String num = "444947137";
        String expected = "7449447";
        Assertions.assertEquals(expected, solution6166.largestPalindromic(num));
    }

    @Test
    public void example2() {
        String num = "00009";
        String expected = "9";
        Assertions.assertEquals(expected, solution6166.largestPalindromic(num));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/352916524/
        // 全为 0 的情况
        String num = UtUtils.loadingString("solution6166-example3-input.txt", 0);
        String expected = "0";
        Assertions.assertEquals(expected, solution6166.largestPalindromic(num));
    }
}
