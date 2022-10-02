import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6198Tests {
    private final Solution6198 solution6198 = new Solution6198();

    @Test
    public void example1() {
        int[] nums1 = {3, 2, 5};
        int[] nums2 = {2, 2, 1};
        int diff = 1;
        long expected = 3;
        Assertions.assertEquals(expected, solution6198.numberOfPairs(nums1, nums2, diff));
    }

    @Test
    public void example2() {
        int[] nums1 = {3, -1};
        int[] nums2 = {-2, 2};
        int diff = -1;
        long expected = 0;
        Assertions.assertEquals(expected, solution6198.numberOfPairs(nums1, nums2, diff));
    }
}
