import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100306Tests {
    private final Solution100306 solution100306 = new Solution100306();

    @Test
    public void example1() {
        int[] nums = {3, 5, 9};
        int[][] queries = UtUtils.stringToInts2("[[1,-2],[0,-3]]");
        int expected = 21;
        Assertions.assertEquals(expected, solution100306.maximumSumSubsequence(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {0, -1};
        int[][] queries = UtUtils.stringToInts2("[[0,-5]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution100306.maximumSumSubsequence(nums, queries));
    }
}