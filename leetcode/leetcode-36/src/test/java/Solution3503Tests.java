import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3503Tests {
    private final Solution3503 solution3503 = new Solution3503();

    @Test
    public void example1() {
        String s = "a";
        String t = "a";
        int expected = 2;
        Assertions.assertEquals(expected, solution3503.longestPalindrome(s, t));
    }

    @Test
    public void example2() {
        String s = "abc";
        String t = "def";
        int expected = 1;
        Assertions.assertEquals(expected, solution3503.longestPalindrome(s, t));
    }

    @Test
    public void example3() {
        String s = "b";
        String t = "aaaa";
        int expected = 4;
        Assertions.assertEquals(expected, solution3503.longestPalindrome(s, t));
    }

    @Test
    public void example4() {
        String s = "abcde";
        String t = "ecdba";
        int expected = 5;
        Assertions.assertEquals(expected, solution3503.longestPalindrome(s, t));
    }
}