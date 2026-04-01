import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3884Tests {
    private final Solution3884 solution3884 = new Solution3884();

    @Test
    public void example1() {
        String s = "abcacbd";
        int expected = 1;
        Assertions.assertEquals(expected, solution3884.firstMatchingIndex(s));
    }

    @Test
    public void example2() {
        String s = "abc";
        int expected = 1;
        Assertions.assertEquals(expected, solution3884.firstMatchingIndex(s));
    }

    @Test
    public void example3() {
        String s = "abcdab";
        int expected = -1;
        Assertions.assertEquals(expected, solution3884.firstMatchingIndex(s));
    }
}