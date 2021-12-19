import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5958Tests {
    private final Solution5958 solution5958 = new Solution5958();

    @Test
    public void example1() {
        int[] prices = {3, 2, 1, 4};
        int expected = 7;
        Assertions.assertEquals(expected, solution5958.getDescentPeriods(prices));
    }

    @Test
    public void example2() {
        int[] prices = {8, 6, 7, 7};
        int expected = 4;
        Assertions.assertEquals(expected, solution5958.getDescentPeriods(prices));
    }

    @Test
    public void example3() {
        int[] prices = {1};
        int expected = 1;
        Assertions.assertEquals(expected, solution5958.getDescentPeriods(prices));
    }
}
