import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3878Tests {
    private final Solution3878 solution3878 = new Solution3878();

    @Test
    public void example1() {
        int[] nums = {4, 2, 3};
        long expected = 4;
        Assertions.assertEquals(expected, solution3878.countGoodSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 3, 1};
        long expected = 6;
        Assertions.assertEquals(expected, solution3878.countGoodSubarrays(nums));
    }
}