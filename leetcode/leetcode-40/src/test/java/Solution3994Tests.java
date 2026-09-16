import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3994Tests {
    private final Solution3994 solution3994 = new Solution3994();

    @Test
    public void example1() {
        int[] nums = {1, 3, 2, 4, 5, 6};
        int a = 3;
        int b = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution3994.minAdjacentSwaps(nums, a, b));
    }

    @Test
    public void example2() {
        int[] nums = {9, 7, 5, 3};
        int a = 4;
        int b = 8;
        int expected = 5;
        Assertions.assertEquals(expected, solution3994.minAdjacentSwaps(nums, a, b));
    }

    @Test
    public void example3() {
        int[] nums = {3, 7, 5, 9};
        int a = 4;
        int b = 8;
        int expected = 0;
        Assertions.assertEquals(expected, solution3994.minAdjacentSwaps(nums, a, b));
    }
}