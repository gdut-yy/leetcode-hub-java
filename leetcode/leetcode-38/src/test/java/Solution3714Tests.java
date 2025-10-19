import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3714Tests {
    private final Solution3714 solution3714 = new Solution3714();

    @Test
    public void example1() {
        String s = "abbac";
        int expected = 4;
        Assertions.assertEquals(expected, solution3714.longestBalanced(s));
    }

    @Test
    public void example2() {
        String s = "aabcc";
        int expected = 3;
        Assertions.assertEquals(expected, solution3714.longestBalanced(s));
    }

    @Test
    public void example3() {
        String s = "aba";
        int expected = 2;
        Assertions.assertEquals(expected, solution3714.longestBalanced(s));
    }
}