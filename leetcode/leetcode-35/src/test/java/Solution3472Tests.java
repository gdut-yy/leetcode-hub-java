import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3472Tests {
    private final Solution3472 solution3472 = new Solution3472();

    @Test
    public void example1() {
        String s = "abced";
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution3472.longestPalindromicSubsequence(s, k));
    }

    @Test
    public void example2() {
        String s = "aaazzz";
        int k = 4;
        int expected = 6;
        Assertions.assertEquals(expected, solution3472.longestPalindromicSubsequence(s, k));
    }
}