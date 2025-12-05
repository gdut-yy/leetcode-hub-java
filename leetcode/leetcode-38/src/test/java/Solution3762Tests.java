import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3762Tests {
    private final Solution3762 solution3762 = new Solution3762();

    @Test
    public void example1() {
        int[] nums = {1, 4, 7};
        int k = 3;
        int[][] queries = UtUtils.stringToInts2("[[0,1],[0,2]]");
        long[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution3762.minOperations(nums, k, queries));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 4};
        int k = 2;
        int[][] queries = UtUtils.stringToInts2("[[0,2],[0,0],[1,2]]");
        long[] expected = {-1, 0, 1};
        Assertions.assertArrayEquals(expected, solution3762.minOperations(nums, k, queries));
    }
}