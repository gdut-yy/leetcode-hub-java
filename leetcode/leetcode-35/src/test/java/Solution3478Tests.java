import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3478Tests {
    private final Solution3478 solution3478 = new Solution3478();

    @Test
    public void example1() {
        int[] nums1 = {4, 2, 1, 5, 3};
        int[] nums2 = {10, 20, 30, 40, 50};
        int k = 2;
        long[] expected = {80, 30, 0, 80, 50};
        Assertions.assertArrayEquals(expected, solution3478.findMaxSum(nums1, nums2, k));
    }

    @Test
    public void example2() {
        int[] nums1 = {2, 2, 2, 2};
        int[] nums2 = {3, 1, 2, 3};
        int k = 1;
        long[] expected = {0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solution3478.findMaxSum(nums1, nums2, k));
    }
}