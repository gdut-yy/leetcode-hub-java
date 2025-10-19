import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3713Tests {
    private final Solution3713 solution3713 = new Solution3713();

    @Test
    public void example1() {
        String s = "abbac";
        int expected = 4;
        Assertions.assertEquals(expected, solution3713.longestBalanced(s));
    }

    @Test
    public void example2() {
        String s = "zzabccy";
        int expected = 4;
        Assertions.assertEquals(expected, solution3713.longestBalanced(s));
    }

    @Test
    public void example3() {
        String s = "aba";
        int expected = 2;
        Assertions.assertEquals(expected, solution3713.longestBalanced(s));
    }
}