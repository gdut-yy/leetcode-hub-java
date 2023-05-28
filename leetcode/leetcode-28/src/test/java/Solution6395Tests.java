import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6395Tests {
    private final Solution6395 solution6395 = new Solution6395();

    @Test
    public void example1() {
        int[] prices = {1, 2, 2};
        int money = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solution6395.buyChoco(prices, money));
    }

    @Test
    public void example2() {
        int[] prices = {3, 2, 3};
        int money = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution6395.buyChoco(prices, money));
    }
}