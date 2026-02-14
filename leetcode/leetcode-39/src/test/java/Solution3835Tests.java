import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3835Tests {
    private final Solution3835 solution3835 = new Solution3835();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2};
        long k = 4;
        long expected = 5;
        Assertions.assertEquals(expected, solution3835.countSubarrays(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {5, 5, 5, 5};
        long k = 0;
        long expected = 10;
        Assertions.assertEquals(expected, solution3835.countSubarrays(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        long k = 0;
        long expected = 3;
        Assertions.assertEquals(expected, solution3835.countSubarrays(nums, k));
    }
}