import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100232Tests {
    private final Solution100232 solution100232 = new Solution100232();

    @Test
    public void example1() {
        int[] nums = {2, 11, 10, 1, 3};
        int k = 10;
        int expected = 2;
        Assertions.assertEquals(expected, solution100232.minOperations(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 2, 4, 9};
        int k = 20;
        int expected = 4;
        Assertions.assertEquals(expected, solution100232.minOperations(nums, k));
    }
}