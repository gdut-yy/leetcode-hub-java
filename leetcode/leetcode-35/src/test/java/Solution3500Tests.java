import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3500Tests {
    private final Solution3500 solution3500 = new Solution3500();

    @Test
    public void example1() {
        int[] nums = {3, 1, 4};
        int[] cost = {4, 6, 6};
        int k = 1;
        long expected = 110;
        Assertions.assertEquals(expected, solution3500.minimumCost(nums, cost, k));
    }

    @Test
    public void example2() {
        int[] nums = {4, 8, 5, 1, 14, 2, 2, 12, 1};
        int[] cost = {7, 2, 8, 4, 2, 2, 1, 1, 2};
        int k = 7;
        long expected = 985;
        Assertions.assertEquals(expected, solution3500.minimumCost(nums, cost, k));
    }
}