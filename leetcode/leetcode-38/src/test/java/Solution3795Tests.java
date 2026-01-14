import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3795Tests {
    private final Solution3795 solution3795 = new Solution3795();

    @Test
    public void example1() {
        int[] nums = {2, 2, 3, 1};
        int k = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution3795.minLength(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 3, 4};
        int k = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution3795.minLength(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {5, 5, 4};
        int k = 5;
        int expected = 1;
        Assertions.assertEquals(expected, solution3795.minLength(nums, k));
    }
}