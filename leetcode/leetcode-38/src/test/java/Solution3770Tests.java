import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3770Tests {
    private final Solution3770 solution3770 = new Solution3770();

    @Test
    public void example1() {
        int n = 20;
        int expected = 17;
        Assertions.assertEquals(expected, solution3770.largestPrime(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3770.largestPrime(n));
    }
}