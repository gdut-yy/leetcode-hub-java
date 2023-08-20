import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution8014Tests {
    private final Solution8014 solution8014 = new Solution8014();

    @Test
    public void example1() {
        String str1 = "abc";
        String str2 = "ad";
        Assertions.assertTrue(solution8014.canMakeSubsequence(str1, str2));
    }

    @Test
    public void example2() {
        String str1 = "zc";
        String str2 = "ad";
        Assertions.assertTrue(solution8014.canMakeSubsequence(str1, str2));
    }

    @Test
    public void example3() {
        String str1 = "ab";
        String str2 = "d";
        Assertions.assertFalse(solution8014.canMakeSubsequence(str1, str2));
    }
}