import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution340Tests {
    private final Solution340 solution340 = new Solution340();

    @Test
    public void example1() {
        String s = "eceba";
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution340.lengthOfLongestSubstringKDistinct(s, k));
    }

    @Test
    public void example2() {
        String s = "aa";
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution340.lengthOfLongestSubstringKDistinct(s, k));
    }
}
