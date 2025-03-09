import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3469Tests {
    private final Solution3469 solution3469 = new Solution3469();

    @Test
    public void example1() {
        int[] nums = {6, 2, 8, 4};
        int expected = 12;
        Assertions.assertEquals(expected, solution3469.minCost(nums));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 3, 3};
        int expected = 5;
        Assertions.assertEquals(expected, solution3469.minCost(nums));
    }
}