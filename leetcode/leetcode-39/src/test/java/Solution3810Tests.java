import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3810Tests {
    private final Solution3810 solution3810 = new Solution3810();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int[] target = {2, 1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution3810.minOperations(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {4, 1, 4};
        int[] target = {5, 1, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solution3810.minOperations(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {7, 3, 7};
        int[] target = {5, 5, 9};
        int expected = 2;
        Assertions.assertEquals(expected, solution3810.minOperations(nums, target));
    }
}