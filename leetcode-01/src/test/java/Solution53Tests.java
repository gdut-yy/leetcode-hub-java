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
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int expected = 1;
        Assertions.assertEquals(expected, solution53.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53.maxSubArray2(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0};
        int expected = 0;
        Assertions.assertEquals(expected, solution53.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53.maxSubArray2(nums));
    }

    @Test
    public void example4() {
        int[] nums = {-1};
        int expected = -1;
        Assertions.assertEquals(expected, solution53.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53.maxSubArray2(nums));
    }

    @Test
    public void example5() {
        int[] nums = {-100000};
        int expected = -100000;
        Assertions.assertEquals(expected, solution53.maxSubArray(nums));
        Assertions.assertEquals(expected, solution53.maxSubArray2(nums));
    }
}
