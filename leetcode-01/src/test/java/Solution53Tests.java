import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution53Tests {
    private final Solution53 solution53 = new Solution53();

    @Test
    public void example1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6;
        Assertions.assertEquals(expected, solution53.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53.maxSubArray2(nums));
        Assertions.assertEquals(expected, solution53.maxSubArray3(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int expected = 1;
        Assertions.assertEquals(expected, solution53.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53.maxSubArray2(nums));
        Assertions.assertEquals(expected, solution53.maxSubArray3(nums));
    }

    @Test
    public void example3() {
        int[] nums = {5, 4, -1, 7, 8};
        int expected = 23;
        Assertions.assertEquals(expected, solution53.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53.maxSubArray2(nums));
        Assertions.assertEquals(expected, solution53.maxSubArray3(nums));
    }
}
