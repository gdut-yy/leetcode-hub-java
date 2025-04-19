import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3504Tests {
    private final Solution3504.V1 solution3504_v1 = new Solution3504.V1();
    private final Solution3504.V2 solution3504_v2 = new Solution3504.V2();

    @Test
    public void example1() {
        String s = "a";
        String t = "a";
        int expected = 2;
        Assertions.assertEquals(expected, solution3504_v1.longestPalindrome(s, t));
        Assertions.assertEquals(expected, solution3504_v2.longestPalindrome(s, t));
    }

    @Test
    public void example2() {
        String s = "abc";
        String t = "def";
        int expected = 1;
        Assertions.assertEquals(expected, solution3504_v1.longestPalindrome(s, t));
        Assertions.assertEquals(expected, solution3504_v2.longestPalindrome(s, t));
    }

    @Test
    public void example3() {
        String s = "b";
        String t = "aaaa";
        int expected = 4;
        Assertions.assertEquals(expected, solution3504_v1.longestPalindrome(s, t));
        Assertions.assertEquals(expected, solution3504_v2.longestPalindrome(s, t));
    }

    @Test
    public void example4() {
        String s = "abcde";
        String t = "ecdba";
        int expected = 5;
        Assertions.assertEquals(expected, solution3504_v1.longestPalindrome(s, t));
        Assertions.assertEquals(expected, solution3504_v2.longestPalindrome(s, t));
    }
}