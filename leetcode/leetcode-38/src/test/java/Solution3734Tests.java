import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3734Tests {
    private final Solution3734 solution3734 = new Solution3734();

    @Test
    public void example1() {
        String s = "baba";
        String target = "abba";
        String expected = "baab";
        Assertions.assertEquals(expected, solution3734.lexPalindromicPermutation(s, target));
    }

    @Test
    public void example2() {
        String s = "baba";
        String target = "bbaa";
        String expected = "";
        Assertions.assertEquals(expected, solution3734.lexPalindromicPermutation(s, target));
    }

    @Test
    public void example3() {
        String s = "abc";
        String target = "abb";
        String expected = "";
        Assertions.assertEquals(expected, solution3734.lexPalindromicPermutation(s, target));
    }

    @Test
    public void example4() {
        String s = "aac";
        String target = "abb";
        String expected = "aca";
        Assertions.assertEquals(expected, solution3734.lexPalindromicPermutation(s, target));
    }
}