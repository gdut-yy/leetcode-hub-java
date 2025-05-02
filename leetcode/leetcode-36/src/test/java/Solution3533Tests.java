import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3533Tests {
    private final Solution3533 solution3533 = new Solution3533();

    @Test
    public void example1() {
        int[] nums = {3, 12, 45};
        int k = 5;
        int[] expected = {3, 12, 45};
        Assertions.assertArrayEquals(expected, solution3533.concatenatedDivisibility(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {10, 5};
        int k = 10;
        int[] expected = {5, 10};
        Assertions.assertArrayEquals(expected, solution3533.concatenatedDivisibility(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3};
        int k = 5;
        int[] expected = {};
        Assertions.assertArrayEquals(expected, solution3533.concatenatedDivisibility(nums, k));
    }
}