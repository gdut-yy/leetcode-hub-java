import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4040Tests {
    private final Solution4040 solution4040 = new Solution4040();

    @Test
    public void example1() {
        int[] nums = {5, 6, 10};
        int sum = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution4040.minOperations(nums, sum));
    }

    @Test
    public void example2() {
        int[] nums = {10, 2};
        int sum = 13;
        int expected = 3;
        Assertions.assertEquals(expected, solution4040.minOperations(nums, sum));
    }

    @Test
    public void example3() {
        int[] nums = {6, 3};
        int sum = 8;
        int expected = -1;
        Assertions.assertEquals(expected, solution4040.minOperations(nums, sum));
    }
}