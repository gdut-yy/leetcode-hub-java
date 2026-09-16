import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4014Tests {
    private final Solution4014 solution4014 = new Solution4014();
    // 与实际答案的误差在 10^-5 以内的结果都将被接受。
    static final double DELTA = 1e-5;

    @Test
    public void example1() {
        int[] prices = {10, 30, 21};
        int[] discounts = {50, 60};
        double expected = 32.50000;
        Assertions.assertEquals(expected, solution4014.minPrice(prices, discounts), DELTA);
    }

    @Test
    public void example2() {
        int[] prices = {100, 70};
        int[] discounts = {10, 40, 50};
        double expected = 92.00000;
        Assertions.assertEquals(expected, solution4014.minPrice(prices, discounts), DELTA);
    }

    @Test
    public void example3() {
        int[] prices = {7, 3, 9};
        int[] discounts = {100, 100};
        double expected = 3.00000;
        Assertions.assertEquals(expected, solution4014.minPrice(prices, discounts), DELTA);
    }
}