import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6449Tests {
    private final Solution6449 solution6449 = new Solution6449();

    @Test
    public void example1() {
        int[] nums = {20, 1, 15};
        int x = 5;
        long expected = 13;
        Assertions.assertEquals(expected, solution6449.minCost(nums, x));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int x = 4;
        long expected = 6;
        Assertions.assertEquals(expected, solution6449.minCost(nums, x));
    }
}