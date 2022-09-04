import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6171Tests {
    private final Solution6171 solution6171 = new Solution6171();

    @Test
    public void example1() {
        int[] nums = {4, 2, 4};
        Assertions.assertTrue(solution6171.findSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        Assertions.assertFalse(solution6171.findSubarrays(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0, 0, 0};
        Assertions.assertTrue(solution6171.findSubarrays(nums));
    }
}
