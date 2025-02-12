import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3444Tests {
    private final Solution3444 solution3444 = new Solution3444();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int[] target = {4};
        int expected = 1;
        Assertions.assertEquals(expected, solution3444.minimumIncrements(nums, target));
    }

    @Test
    public void example2() {
        int[] nums = {8, 4};
        int[] target = {10, 5};
        int expected = 2;
        Assertions.assertEquals(expected, solution3444.minimumIncrements(nums, target));
    }

    @Test
    public void example3() {
        int[] nums = {7, 9, 10};
        int[] target = {7};
        int expected = 0;
        Assertions.assertEquals(expected, solution3444.minimumIncrements(nums, target));
    }
}