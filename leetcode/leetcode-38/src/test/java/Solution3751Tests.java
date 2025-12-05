import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3751Tests {
    private final Solution3751 solution3751 = new Solution3751();

    @Test
    public void example1() {
        int num1 = 120;
        int num2 = 130;
        int expected = 3;
        Assertions.assertEquals(expected, solution3751.totalWaviness(num1, num2));
    }

    @Test
    public void example2() {
        int num1 = 198;
        int num2 = 202;
        int expected = 3;
        Assertions.assertEquals(expected, solution3751.totalWaviness(num1, num2));
    }

    @Test
    public void example3() {
        int num1 = 4848;
        int num2 = 4848;
        int expected = 2;
        Assertions.assertEquals(expected, solution3751.totalWaviness(num1, num2));
    }
}