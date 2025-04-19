import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3512Tests {
    private final Solution3512 solution3512 = new Solution3512();

    @Test
    public void example1() {
        int[] nums = {3, 9, 7};
        int k = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution3512.minOperations(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4, 1, 3};
        int k = 4;
        int expected = 0;
        Assertions.assertEquals(expected, solution3512.minOperations(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {3, 2};
        int k = 6;
        int expected = 5;
        Assertions.assertEquals(expected, solution3512.minOperations(nums, k));
    }
}