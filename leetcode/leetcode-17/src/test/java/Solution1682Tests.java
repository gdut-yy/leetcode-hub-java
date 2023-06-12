import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1682Tests {
    private final Solution1682 solution1682 = new Solution1682();

    @Test
    public void example1() {
        String s = "bbabab";
        int expected = 4;
        Assertions.assertEquals(expected, solution1682.longestPalindromeSubseq(s));
    }

    @Test
    public void example2() {
        String s = "dcbccacdb";
        int expected = 4;
        Assertions.assertEquals(expected, solution1682.longestPalindromeSubseq(s));
    }
}