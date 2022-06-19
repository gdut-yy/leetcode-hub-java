import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6099Tests {
    private final Solution6099 solution6099 = new Solution6099();

    @Test
    public void example1() {
        String s = "1001010";
        int k = 5;
        int expected = 5;
        Assertions.assertEquals(expected, solution6099.longestSubsequence(s, k));
    }

    @Test
    public void example2() {
        String s = "00101001";
        int k = 1;
        int expected = 6;
        Assertions.assertEquals(expected, solution6099.longestSubsequence(s, k));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/326894183/
        // 爆 int
        String s = "111100010000011101001110001111000000001011101111111110111000011111011000010101110100110110001111001001011001010011010000011111101001101000000101101001110110000111101011000101";
        int k = 11713332;
        int expected = 96;
        Assertions.assertEquals(expected, solution6099.longestSubsequence(s, k));
    }
}
