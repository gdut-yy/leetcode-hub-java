import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3892Tests {
    private final Solution3892 solution3892 = new Solution3892();

    @Test
    public void example1() {
        int[] nums = {2, 1, 2};
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution3892.minOperations(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4, 5, 3, 6};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution3892.minOperations(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {3, 7, 3};
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution3892.minOperations(nums, k));
    }
}