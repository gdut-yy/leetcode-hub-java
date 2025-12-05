import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3753Tests {
    private final Solution3753 solution3753 = new Solution3753();

    @Test
    public void example1() {
        long num1 = 120;
        long num2 = 130;
        long expected = 3;
        Assertions.assertEquals(expected, solution3753.totalWaviness(num1, num2));
    }

    @Test
    public void example2() {
        long num1 = 198;
        long num2 = 202;
        long expected = 3;
        Assertions.assertEquals(expected, solution3753.totalWaviness(num1, num2));
    }

    @Test
    public void example3() {
        long num1 = 4848;
        long num2 = 4848;
        long expected = 2;
        Assertions.assertEquals(expected, solution3753.totalWaviness(num1, num2));
    }
}