import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3927Tests {
    private final Solution3927 solution3927 = new Solution3927();

    @Test
    public void example1() {
        int[] nums = {3, 6, 2};
        long expected = 7;
        Assertions.assertEquals(expected, solution3927.minArraySum(nums));
    }

    @Test
    public void example2() {
        int[] nums = {4, 2, 8, 3};
        long expected = 9;
        Assertions.assertEquals(expected, solution3927.minArraySum(nums));
    }

    @Test
    public void example3() {
        int[] nums = {7, 5, 9};
        long expected = 21;
        Assertions.assertEquals(expected, solution3927.minArraySum(nums));
    }
}