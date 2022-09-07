import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1063Tests {
    private final Solution1063 solution1063 = new Solution1063();

    @Test
    public void example1() {
        int[] nums = {1, 4, 2, 5, 3};
        int expected = 11;
        Assertions.assertEquals(expected, solution1063.validSubarrays(nums));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution1063.validSubarrays(nums));
    }

    @Test
    public void example3() {
        int[] nums = {2, 2, 2};
        int expected = 6;
        Assertions.assertEquals(expected, solution1063.validSubarrays(nums));
    }
}
