import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3850Tests {
    private final Solution3850 solution3850 = new Solution3850();

    @Test
    public void example1() {
        int[] nums = {2, 3, 2};
        long k = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution3850.countSequences(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {4, 6, 3};
        long k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3850.countSequences(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 5};
        long k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution3850.countSequences(nums, k));
    }
}