import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3641Tests {
    private final SolutionP3641 solutionP3641 = new SolutionP3641();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3, 1, 2, 3, 4};
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3641.longestSubarray(nums, k));
    }

    @Test
    public void example2() {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 4;
        int expected = 5;
        Assertions.assertEquals(expected, solutionP3641.longestSubarray(nums, k));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3641.longestSubarray(nums, k));
    }
}