import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3900Tests {
    private final Solution3900 solution3900 = new Solution3900();

    @Test
    public void example1() {
        String s = "100001";
        int expected = 4;
        Assertions.assertEquals(expected, solution3900.longestBalanced(s));
    }

    @Test
    public void example2() {
        String s = "111";
        int expected = 0;
        Assertions.assertEquals(expected, solution3900.longestBalanced(s));
    }
}