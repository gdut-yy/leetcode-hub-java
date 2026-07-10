import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3974Tests {
    private final Solution3974 solution3974 = new Solution3974();

    @Test
    public void example1() {
        int[] nums = {6, 1, 2, 9};
        int k = 3;
        int mul = 2;
        long expected = 26;
        Assertions.assertEquals(expected, solution3974.maxSum(nums, k, mul));
    }

    @Test
    public void example2() {
        int[] nums = {3, 7, 5, 2};
        int k = 2;
        int mul = 4;
        long expected = 43;
        Assertions.assertEquals(expected, solution3974.maxSum(nums, k, mul));
    }

    @Test
    public void example3() {
        int[] nums = {4, 4};
        int k = 1;
        int mul = 1;
        long expected = 4;
        Assertions.assertEquals(expected, solution3974.maxSum(nums, k, mul));
    }
}