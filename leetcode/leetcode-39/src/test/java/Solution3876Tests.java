import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3876Tests {
    private final Solution3876 solution3876 = new Solution3876();

    @Test
    public void example1() {
        int[] nums1 = {1, 4, 7};
        Assertions.assertTrue(solution3876.uniformArray(nums1));
    }

    @Test
    public void example2() {
        int[] nums1 = {2, 3};
        Assertions.assertFalse(solution3876.uniformArray(nums1));
    }

    @Test
    public void example3() {
        int[] nums1 = {4, 6};
        Assertions.assertTrue(solution3876.uniformArray(nums1));
    }
}