import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3420Tests {
    private final Solution3420 solution3420 = new Solution3420();

    @Test
    public void example1() {
        int[] nums = {6, 3, 1, 2, 4, 4};
        int k = 7;
        long expected = 17;
        Assertions.assertEquals(expected, solution3420.countNonDecreasingSubarrays(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {6, 3, 1, 3, 6};
        int k = 4;
        long expected = 12;
        Assertions.assertEquals(expected, solution3420.countNonDecreasingSubarrays(nums, k));
    }
}