import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3684Tests {
    private final Solution3684 solution3684 = new Solution3684();

    @Test
    public void example1() {
        int[] nums = {84, 93, 100, 77, 90};
        int k = 3;
        int[] expected = {100, 93, 90};
        Assertions.assertArrayEquals(expected, solution3684.maxKDistinct(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {84, 93, 100, 77, 93};
        int k = 3;
        int[] expected = {100, 93, 84};
        Assertions.assertArrayEquals(expected, solution3684.maxKDistinct(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 2, 2, 2};
        int k = 6;
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution3684.maxKDistinct(nums, k));
    }
}