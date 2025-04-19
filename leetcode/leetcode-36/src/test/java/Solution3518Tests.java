import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3518Tests {
    private final Solution3518 solution3518 = new Solution3518();

    @Test
    public void example1() {
        String s = "abba";
        int k = 2;
        String expected = "baab";
        Assertions.assertEquals(expected, solution3518.smallestPalindrome(s, k));
    }

    @Test
    public void example2() {
        String s = "aa";
        int k = 2;
        String expected = "";
        Assertions.assertEquals(expected, solution3518.smallestPalindrome(s, k));
    }

    @Test
    public void example3() {
        String s = "bacab";
        int k = 1;
        String expected = "abcba";
        Assertions.assertEquals(expected, solution3518.smallestPalindrome(s, k));
    }
}