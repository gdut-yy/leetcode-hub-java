import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3870Tests {
    private final Solution3870 solution3870 = new Solution3870();

    @Test
    public void example1() {
        int n = 1002;
        int expected = 3;
        Assertions.assertEquals(expected, solution3870.countCommas(n));
    }

    @Test
    public void example2() {
        int n = 998;
        int expected = 0;
        Assertions.assertEquals(expected, solution3870.countCommas(n));
    }
}