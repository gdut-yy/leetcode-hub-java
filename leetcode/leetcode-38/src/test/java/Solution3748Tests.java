import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3748Tests {
    private final Solution3748 solution3748 = new Solution3748();

    @Test
    public void example1() {
        int[] nums = {3, 1, 2};
        int[][] queries = UtUtils.stringToInts2("[[0,1],[1,2],[0,2]]");
        long[] expected = {2, 3, 4};
        Assertions.assertArrayEquals(expected, solution3748.countStableSubarrays(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {2, 2};
        int[][] queries = UtUtils.stringToInts2("[[0,1],[0,0]]");
        long[] expected = {3, 1};
        Assertions.assertArrayEquals(expected, solution3748.countStableSubarrays(nums, queries));
    }
}