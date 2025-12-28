import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3781Tests {
    private final Solution3781 solution3781 = new Solution3781();

    @Test
    public void example1() {
        int[] nums = {2, 1, 5, 2, 3};
        String s = "01010";
        long expected = 7;
        Assertions.assertEquals(expected, solution3781.maximumScore(nums, s));
    }

    @Test
    public void example2() {
        int[] nums = {4, 7, 2, 9};
        String s = "0000";
        long expected = 0;
        Assertions.assertEquals(expected, solution3781.maximumScore(nums, s));
    }
}