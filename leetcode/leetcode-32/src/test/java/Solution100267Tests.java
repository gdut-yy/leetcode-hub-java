import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100267Tests {
    private final Solution100267 solution100267 = new Solution100267();

    @Test
    public void example1() {
        int[] coins = {3, 6, 9};
        int k = 3;
        long expected = 9;
        Assertions.assertEquals(expected, solution100267.findKthSmallest(coins, k));
    }

    @Test
    public void example2() {
        int[] coins = {5, 2};
        int k = 7;
        long expected = 12;
        Assertions.assertEquals(expected, solution100267.findKthSmallest(coins, k));
    }
}