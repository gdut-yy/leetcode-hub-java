import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6912Tests {
    private final Solution6912 solution6912 = new Solution6912();

    @Test
    public void example1() {
        int[] nums1 = {2, 3, 1};
        int[] nums2 = {1, 2, 1};
        int expected = 2;
        Assertions.assertEquals(expected, solution6912.maxNonDecreasingLength(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 3, 2, 1};
        int[] nums2 = {2, 2, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solution6912.maxNonDecreasingLength(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {1, 1};
        int[] nums2 = {2, 2};
        int expected = 2;
        Assertions.assertEquals(expected, solution6912.maxNonDecreasingLength(nums1, nums2));
    }
}