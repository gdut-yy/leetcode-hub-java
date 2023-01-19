import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution760Tests {
    private final Solution760 solution760 = new Solution760();

    @Test
    public void example1() {
        int[] nums1 = {12, 28, 46, 32, 50};
        int[] nums2 = {50, 12, 32, 46, 28};
        int[] expected = {1, 4, 3, 2, 0};
        Assertions.assertArrayEquals(expected, solution760.anagramMappings(nums1, nums2));
    }
}