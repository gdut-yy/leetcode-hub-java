import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3985Tests {
    private final Solution3985 solution3985 = new Solution3985();

    @Test
    public void example1() {
        int[] nums = {10, 10};
        long expected = 20;
        Assertions.assertEquals(expected, solution3985.getSum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 2, 1, 5, 6};
        long expected = 9;
        Assertions.assertEquals(expected, solution3985.getSum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {7, 1, 2, 1, 7, 3, 4, 3, 4};
        long expected = 18;
        Assertions.assertEquals(expected, solution3985.getSum(nums));
    }

    @Test
    public void example4() {
        int[] nums = {1, 2, 3, 4, 5};
        long expected = 5;
        Assertions.assertEquals(expected, solution3985.getSum(nums));
    }

    @Test
    public void example5() {
        int[] nums = {1000};
        long expected = 1000;
        Assertions.assertEquals(expected, solution3985.getSum(nums));
    }
}