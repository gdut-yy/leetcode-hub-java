import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3868Tests {
    private final Solution3868 solution3868 = new Solution3868();

    @Test
    public void example1() {
        int[] nums1 = {10, 20};
        int[] nums2 = {20, 10};
        int expected = 0;
        Assertions.assertEquals(expected, solution3868.minCost(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {10, 10};
        int[] nums2 = {20, 20};
        int expected = 1;
        Assertions.assertEquals(expected, solution3868.minCost(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {10, 20};
        int[] nums2 = {30, 40};
        int expected = -1;
        Assertions.assertEquals(expected, solution3868.minCost(nums1, nums2));
    }
}