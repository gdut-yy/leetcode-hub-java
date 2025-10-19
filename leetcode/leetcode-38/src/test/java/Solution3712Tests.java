import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3712Tests {
    private final Solution3712 solution3712 = new Solution3712();

    @Test
    public void example1() {
        int[] nums = {1, 2, 2, 3, 3, 3, 3, 4};
        int k = 2;
        int expected = 16;
        Assertions.assertEquals(expected, solution3712.sumDivisibleByK(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution3712.sumDivisibleByK(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {4, 4, 4, 1, 2, 3};
        int k = 3;
        int expected = 12;
        Assertions.assertEquals(expected, solution3712.sumDivisibleByK(nums, k));
    }
}