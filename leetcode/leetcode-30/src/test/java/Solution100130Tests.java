import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100130Tests {
    private final Solution100130 solution100130 = new Solution100130();

    @Test
    public void example1() {
        int[] nums1 = {4, 3, 2, 3, 1};
        int[] nums2 = {2, 2, 5, 2, 3, 6};
        int[] expected = {3, 4};
        Assertions.assertArrayEquals(expected, solution100130.findIntersectionValues(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {3, 4, 2, 3};
        int[] nums2 = {1, 5};
        int[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, solution100130.findIntersectionValues(nums1, nums2));
    }
}