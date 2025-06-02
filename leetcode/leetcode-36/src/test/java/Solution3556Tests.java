import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3556Tests {
    private final Solution3556 solution3556 = new Solution3556();

    @Test
    public void example1() {
        String s = "12234";
        long expected = 1469;
        Assertions.assertEquals(expected, solution3556.sumOfLargestPrimes(s));
    }

    @Test
    public void example2() {
        String s = "111";
        long expected = 11;
        Assertions.assertEquals(expected, solution3556.sumOfLargestPrimes(s));
    }
}