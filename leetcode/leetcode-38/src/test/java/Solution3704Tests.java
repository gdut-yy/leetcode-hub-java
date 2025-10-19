import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3704Tests {
    private final Solution3704 solution3704 = new Solution3704();

    @Test
    public void example1() {
        long n = 2;
        long expected = 1;
        Assertions.assertEquals(expected, solution3704.countNoZeroPairs(n));
    }

    @Test
    public void example2() {
        long n = 3;
        long expected = 2;
        Assertions.assertEquals(expected, solution3704.countNoZeroPairs(n));
    }

    @Test
    public void example3() {
        long n = 11;
        long expected = 8;
        Assertions.assertEquals(expected, solution3704.countNoZeroPairs(n));
    }
}