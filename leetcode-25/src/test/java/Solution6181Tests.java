import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6181Tests {
    private final Solution6181 solution6181 = new Solution6181();

    @Test
    public void example1() {
        String s = "abacaba";
        int expected = 2;
        Assertions.assertEquals(expected, solution6181.longestContinuousSubstring(s));
    }

    @Test
    public void example2() {
        String s = "abcde";
        int expected = 5;
        Assertions.assertEquals(expected, solution6181.longestContinuousSubstring(s));
    }
}
