import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3690Tests {
    private final Solution3690 solution3690 = new Solution3690();

    @Test
    public void example1() {
        int[] nums1 = {3, 1, 2};
        int[] nums2 = {1, 2, 3};
        int expected = 1;
        Assertions.assertEquals(expected, solution3690.minSplitMerge(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 1, 2, 3, 4, 5};
        int[] nums2 = {5, 4, 3, 2, 1, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution3690.minSplitMerge(nums1, nums2));
    }
}