import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3599Tests {
    private final Solution3599.V1 solution3599 = new Solution3599.V1();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int k = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution3599.minXor(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 3, 2};
        int k = 3;
        int expected = 2;
        Assertions.assertEquals(expected, solution3599.minXor(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 2, 3, 1};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution3599.minXor(nums, k));
    }
}