import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3652Tests {
    private final Solution3652 solution3652 = new Solution3652();

    @Test
    public void example1() {
        int[] prices = {4, 2, 8};
        int[] strategy = {-1, 0, 1};
        int k = 2;
        long expected = 10;
        Assertions.assertEquals(expected, solution3652.maxProfit(prices, strategy, k));
    }

    @Test
    public void example2() {
        int[] prices = {5, 4, 3};
        int[] strategy = {1, 1, 0};
        int k = 2;
        long expected = 9;
        Assertions.assertEquals(expected, solution3652.maxProfit(prices, strategy, k));
    }
}