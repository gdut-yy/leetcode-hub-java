import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3695Tests {
    private final Solution3695 solution3695 = new Solution3695();

    @Test
    public void example1() {
        int[] nums = {1, 2, 3};
        int[][] swaps = UtUtils.stringToInts2("[[0,2],[1,2]]");
        long expected = 4;
        Assertions.assertEquals(expected, solution3695.maxAlternatingSum(nums, swaps));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3};
        int[][] swaps = UtUtils.stringToInts2("[[1,2]]");
        long expected = 2;
        Assertions.assertEquals(expected, solution3695.maxAlternatingSum(nums, swaps));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1000000000, 1, 1000000000, 1, 1000000000};
        int[][] swaps = UtUtils.stringToInts2("[]");
        long expected = -2999999997L;
        Assertions.assertEquals(expected, solution3695.maxAlternatingSum(nums, swaps));
    }
}