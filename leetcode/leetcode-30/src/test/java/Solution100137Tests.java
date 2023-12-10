import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100137Tests {
    private final Solution100137 solution100137 = new Solution100137();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 3, 3};
        int k = 2;
        long expected = 6;
        Assertions.assertEquals(expected, solution100137.countSubarrays(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 4, 2, 1};
        int k = 3;
        long expected = 0;
        Assertions.assertEquals(expected, solution100137.countSubarrays(nums, k));
    }
}