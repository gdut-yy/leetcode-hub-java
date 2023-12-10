import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100143Tests {
    private final Solution100143 solution100143 = new Solution100143();

    @Test
    public void example1() {
        int[] batteryPercentages = {1, 1, 2, 1, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solution100143.countTestedDevices(batteryPercentages));
    }

    @Test
    public void example2() {
        int[] batteryPercentages = {0, 1, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution100143.countTestedDevices(batteryPercentages));
    }
}