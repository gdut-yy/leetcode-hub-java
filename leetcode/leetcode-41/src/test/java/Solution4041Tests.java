import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4041Tests {
    private final Solution4041 solution4041 = new Solution4041();

    @Test
    public void example1() {
        int[] nums = {10, 2};
        int sum = 13;
        int expected = 3;
        Assertions.assertEquals(expected, solution4041.minOperations(nums, sum));
    }

    @Test
    public void example2() {
        int[] nums = {6, 3};
        int sum = 8;
        int expected = 2;
        Assertions.assertEquals(expected, solution4041.minOperations(nums, sum));
    }

    @Test
    public void example3() {
        int[] nums = {2, 2};
        int sum = 7;
        int expected = -1;
        Assertions.assertEquals(expected, solution4041.minOperations(nums, sum));
    }
}