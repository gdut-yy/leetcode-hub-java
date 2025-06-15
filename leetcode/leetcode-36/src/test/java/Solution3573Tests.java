import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3573Tests {
    private final Solution3573 solution3573 = new Solution3573();

    @Test
    public void example1() {
        int[] prices = {1, 7, 9, 8, 2};
        int k = 2;
        long expected = 14;
        Assertions.assertEquals(expected, solution3573.maximumProfit(prices, k));
    }

    @Test
    public void example2() {
        int[] prices = {12, 16, 19, 19, 8, 1, 19, 13, 9};
        int k = 3;
        long expected = 36;
        Assertions.assertEquals(expected, solution3573.maximumProfit(prices, k));
    }
}