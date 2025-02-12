import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3442Tests {
    private final Solution3442 solution3442 = new Solution3442();

    @Test
    public void example1() {
        String s = "aaaaabbc";
        int expected = 3;
        Assertions.assertEquals(expected, solution3442.maxDifference(s));
    }

    @Test
    public void example2() {
        String s = "abcabcab";
        int expected = 1;
        Assertions.assertEquals(expected, solution3442.maxDifference(s));
    }
}