import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution159Tests {
    private final Solution159 solution159 = new Solution159();

    @Test
    public void example1() {
        String s = "eceba";
        int expected = 3;
        Assertions.assertEquals(expected, solution159.lengthOfLongestSubstringTwoDistinct(s));
    }

    @Test
    public void example2() {
        String s = "ccaabbb";
        int expected = 5;
        Assertions.assertEquals(expected, solution159.lengthOfLongestSubstringTwoDistinct(s));
    }
}
