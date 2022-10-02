import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6213Tests {
    private final Solution6213 solution6213 = new Solution6213();

    @Test
    public void example1() {
        int[] nums1 = {2, 1, 3};
        int[] nums2 = {10, 2, 5, 0};
        int expected = 13;
        Assertions.assertEquals(expected, solution6213.xorAllNums(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        int expected = 0;
        Assertions.assertEquals(expected, solution6213.xorAllNums(nums1, nums2));
    }
}
