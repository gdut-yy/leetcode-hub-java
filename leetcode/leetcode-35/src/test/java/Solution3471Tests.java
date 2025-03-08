import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3471Tests {
    private final Solution3471 solution3471 = new Solution3471();

    @Test
    public void example1() {
        int[] nums = {3, 9, 2, 1, 7};
        int k = 3;
        int expected = 7;
        Assertions.assertEquals(expected, solution3471.largestInteger(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {3, 9, 7, 2, 1, 7};
        int k = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution3471.largestInteger(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {0, 0};
        int k = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution3471.largestInteger(nums, k));
    }
}