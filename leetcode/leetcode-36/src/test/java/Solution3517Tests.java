import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3517Tests {
    private final Solution3517 solution3517 = new Solution3517();

    @Test
    public void example1() {
        String s = "z";
        String expected = "z";
        Assertions.assertEquals(expected, solution3517.smallestPalindrome(s));
    }

    @Test
    public void example2() {
        String s = "babab";
        String expected = "abbba";
        Assertions.assertEquals(expected, solution3517.smallestPalindrome(s));
    }

    @Test
    public void example3() {
        String s = "daccad";
        String expected = "acddca";
        Assertions.assertEquals(expected, solution3517.smallestPalindrome(s));
    }
}