import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3897Tests {
    private final Solution3897 solution3897 = new Solution3897();

    @Test
    public void example1() {
        int[] nums1 = {1, 2};
        int[] nums0 = {1, 0};
        int expected = 14;
        Assertions.assertEquals(expected, solution3897.maxValue(nums1, nums0));
    }

    @Test
    public void example2() {
        int[] nums1 = {3, 1};
        int[] nums0 = {0, 3};
        int expected = 120;
        Assertions.assertEquals(expected, solution3897.maxValue(nums1, nums0));
    }
}