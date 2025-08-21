import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3636Tests {
    private final Solution3636 solution3636 = new Solution3636();

    @Test
    public void example1() {
        int[] nums = {1, 1, 2, 2, 1, 1};
        int[][] queries = UtUtils.stringToInts2("[[0,5,4],[0,3,3],[2,3,2]]");
        int[] expected = {1, -1, 2};
        Assertions.assertArrayEquals(expected, solution3636.subarrayMajority(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {3, 2, 3, 2, 3, 2, 3};
        int[][] queries = UtUtils.stringToInts2("[[0,6,4],[1,5,2],[2,4,1],[3,3,1]]");
        int[] expected = {3, 2, 3, 2};
        Assertions.assertArrayEquals(expected, solution3636.subarrayMajority(nums, queries));
    }
}