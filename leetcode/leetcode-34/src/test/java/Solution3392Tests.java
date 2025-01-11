import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3392Tests {
    private final Solution3392 solution3392 = new Solution3392();

    @Test
    public void example1() {
        int[] nums = {1, 2, 1, 4, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution3392.countSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution3392.countSubarrays(nums));
    }
}