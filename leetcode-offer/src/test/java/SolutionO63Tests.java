import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO63Tests {
    private final SolutionO63 solutionO63 = new SolutionO63();

    @Test
    public void example1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;
        Assertions.assertEquals(expected, solutionO63.maxProfit(prices));
    }

    @Test
    public void example2() {
        int[] prices = {7, 6, 4, 3, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solutionO63.maxProfit(prices));
    }
}
