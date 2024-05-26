import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100323Tests {
    private final Solution100323 solution100323 = new Solution100323();

    @Test
    public void example1() {
        int[] nums1 = {1, 3, 4};
        int[] nums2 = {1, 3, 4};
        int k = 1;
        int expected = 5;
        Assertions.assertEquals(expected, solution100323.numberOfPairs(nums1, nums2, k));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 2, 4, 12};
        int[] nums2 = {2, 4};
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution100323.numberOfPairs(nums1, nums2, k));
    }
}