import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3724Tests {
    private final Solution3724 solution3724 = new Solution3724();

    @Test
    public void example1() {
        int[] nums1 = {2, 8};
        int[] nums2 = {1, 7, 3};
        long expected = 4;
        Assertions.assertEquals(expected, solution3724.minOperations(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 3, 6};
        int[] nums2 = {2, 4, 5, 3};
        long expected = 4;
        Assertions.assertEquals(expected, solution3724.minOperations(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {2};
        int[] nums2 = {3, 4};
        long expected = 3;
        Assertions.assertEquals(expected, solution3724.minOperations(nums1, nums2));
    }
}