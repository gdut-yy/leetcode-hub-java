import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution516Tests {
    private final Solution516.V1 solution516_v1 = new Solution516.V1();
    private final Solution516.V2 solution516_v2 = new Solution516.V2();

    @Test
    public void example1() {
        String s = "bbbab";
        int expected = 4;
        Assertions.assertEquals(expected, solution516_v1.longestPalindromeSubseq(s));
        Assertions.assertEquals(expected, solution516_v2.longestPalindromeSubseq(s));
    }

    @Test
    public void example2() {
        String s = "cbbd";
        int expected = 2;
        Assertions.assertEquals(expected, solution516_v1.longestPalindromeSubseq(s));
        Assertions.assertEquals(expected, solution516_v2.longestPalindromeSubseq(s));
    }

    // 补充用例
    @Test
    public void example3() {
        String s = "a";
        int expected = 1;
        Assertions.assertEquals(expected, solution516_v1.longestPalindromeSubseq(s));
        Assertions.assertEquals(expected, solution516_v2.longestPalindromeSubseq(s));
    }
}
