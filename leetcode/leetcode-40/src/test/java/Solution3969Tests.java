import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3969Tests {
    private final Solution3969 solution3969 = new Solution3969();

    @Test
    public void example1() {
        int[] nums = {1, 100, 1};
        int x = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution3969.countValidSubarrays(nums, x));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int x = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution3969.countValidSubarrays(nums, x));
    }
}