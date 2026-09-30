import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP4069Tests {
    private final SolutionP4069 solutionP4069 = new SolutionP4069();

    @Test
    public void example1() {
        int[] prices = {1, 5, 3};
        int cooldown = 1;
        int[] costs = {2, 0, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP4069.maxProfit(prices, cooldown, costs));
    }

    @Test
    public void example2() {
        int[] prices = {1, 2, 5};
        int cooldown = 0;
        int[] costs = {0, 2, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solutionP4069.maxProfit(prices, cooldown, costs));
    }

    @Test
    public void example3() {
        int[] prices = {4, 1, 7};
        int cooldown = 2;
        int[] costs = {3, 0, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solutionP4069.maxProfit(prices, cooldown, costs));
    }

    @Test
    public void example4() {
        int[] prices = {3, 1, 4};
        int cooldown = 0;
        int[] costs = {2, 1, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP4069.maxProfit(prices, cooldown, costs));
    }
}
