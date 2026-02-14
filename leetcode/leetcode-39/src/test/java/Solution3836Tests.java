import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3836Tests {
    private final Solution3836 solution3836 = new Solution3836();

    @Test
    public void example1() {
        int[] nums1 = {1, 3, 2};
        int[] nums2 = {4, 5, 1};
        int k = 2;
        long expected = 22;
        Assertions.assertEquals(expected, solution3836.maxScore(nums1, nums2, k));
    }

    @Test
    public void example2() {
        int[] nums1 = {-2, 0, 5};
        int[] nums2 = {-3, 4, -1, 2};
        int k = 2;
        long expected = 26;
        Assertions.assertEquals(expected, solution3836.maxScore(nums1, nums2, k));
    }

    @Test
    public void example3() {
        int[] nums1 = {-3, -2};
        int[] nums2 = {1, 2};
        int k = 2;
        long expected = -7;
        Assertions.assertEquals(expected, solution3836.maxScore(nums1, nums2, k));
    }
}