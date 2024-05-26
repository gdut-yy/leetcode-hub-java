import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1983Tests {
    private final Solution1983 solution1983 = new Solution1983();

    @Test
    public void example1() {
        int[] nums1 = {1, 1, 0, 1};
        int[] nums2 = {0, 1, 1, 0};
        int expected = 3;
        Assertions.assertEquals(expected, solution1983.widestPairOfIndices(nums1, nums2));
    }

    @Test
    public void example2() {
        int[] nums1 = {0, 1};
        int[] nums2 = {1, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1983.widestPairOfIndices(nums1, nums2));
    }

    @Test
    public void example3() {
        int[] nums1 = {0};
        int[] nums2 = {1};
        int expected = 0;
        Assertions.assertEquals(expected, solution1983.widestPairOfIndices(nums1, nums2));
    }
}