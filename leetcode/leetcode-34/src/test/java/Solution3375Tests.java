import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3375Tests {
    private final Solution3375 solution3375 = new Solution3375();

    @Test
    public void example1() {
        int[] nums = {5, 2, 5, 4, 5};
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3375.minOperations(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 1, 2};
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution3375.minOperations(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {9, 7, 5, 3};
        int k = 1;
        int expected = 4;
        Assertions.assertEquals(expected, solution3375.minOperations(nums, k));
    }
}