import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3871Tests {
    private final Solution3871 solution3871 = new Solution3871();

    @Test
    public void example1() {
        long n = 1002;
        long expected = 3;
        Assertions.assertEquals(expected, solution3871.countCommas(n));
    }

    @Test
    public void example2() {
        long n = 998;
        long expected = 0;
        Assertions.assertEquals(expected, solution3871.countCommas(n));
    }
}