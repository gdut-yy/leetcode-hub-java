import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100107Tests {
    private final Solution100107 solution100107 = new Solution100107();

    @Test
    public void example1() {
        int[] nums = {2, 3, 0, 0, 2};
        int k = 4;
        long expected = 3;
        Assertions.assertEquals(expected, solution100107.minIncrementOperations(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {0, 1, 3, 3};
        int k = 5;
        long expected = 2;
        Assertions.assertEquals(expected, solution100107.minIncrementOperations(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 2};
        int k = 1;
        long expected = 0;
        Assertions.assertEquals(expected, solution100107.minIncrementOperations(nums, k));
    }
}