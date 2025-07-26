import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3624Tests {
    private final Solution3624 solution3624 = new Solution3624();

    @Test
    public void example1() {
        long[] nums = {2, 4};
        long[][] queries = UtUtils.stringToLongs2("[[1,0,1,1],[2,1,1],[1,0,1,0]]");
        int[] expected = {2, 1};
        Assertions.assertArrayEquals(expected, solution3624.popcountDepth(nums, queries));
    }

    @Test
    public void example2() {
        long[] nums = {3, 5, 6};
        long[][] queries = UtUtils.stringToLongs2("[[1,0,2,2],[2,1,4],[1,1,2,1],[1,0,1,0]]");
        int[] expected = {3, 1, 0};
        Assertions.assertArrayEquals(expected, solution3624.popcountDepth(nums, queries));
    }

    @Test
    public void example3() {
        long[] nums = {1, 2};
        long[][] queries = UtUtils.stringToLongs2("[[1,0,1,1],[2,0,3],[1,0,0,1],[1,0,0,2]]");
        int[] expected = {1, 0, 1};
        Assertions.assertArrayEquals(expected, solution3624.popcountDepth(nums, queries));
    }
}