import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution239Tests {
    private final Solution239 solution239 = new Solution239();

    @Test
    public void example1() {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] expected = {3, 3, 5, 5, 6, 7};
        Assertions.assertArrayEquals(expected, solution239.maxSlidingWindow(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1};
        int k = 1;
        int[] expected = {1};
        Assertions.assertArrayEquals(expected, solution239.maxSlidingWindow(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, -1};
        int k = 1;
        int[] expected = {1, -1};
        Assertions.assertArrayEquals(expected, solution239.maxSlidingWindow(nums, k));
    }

    @Test
    public void example4() {
        int[] nums = {9, 11};
        int k = 2;
        int[] expected = {11};
        Assertions.assertArrayEquals(expected, solution239.maxSlidingWindow(nums, k));
    }

    @Test
    public void example5() {
        int[] nums = {4, -2};
        int k = 2;
        int[] expected = {4};
        Assertions.assertArrayEquals(expected, solution239.maxSlidingWindow(nums, k));
    }
}
