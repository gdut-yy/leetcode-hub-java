import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3844Tests {
    private final Solution3844 solution3844 = new Solution3844();

    @Test
    public void example1() {
        String s = "abca";
        int expected = 4;
        Assertions.assertEquals(expected, solution3844.almostPalindromic(s));
    }

    @Test
    public void example2() {
        String s = "abba";
        int expected = 4;
        Assertions.assertEquals(expected, solution3844.almostPalindromic(s));
    }

    @Test
    public void example3() {
        String s = "zzabba";
        int expected = 5;
        Assertions.assertEquals(expected, solution3844.almostPalindromic(s));
    }
}