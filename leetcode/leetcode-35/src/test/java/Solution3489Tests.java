import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3489Tests {
    private final Solution3489 solution3489 = new Solution3489();

    @Test
    public void example1() {
        int[] nums = {2, 0, 2};
        int[][] queries = UtUtils.stringToInts2("[[0,2,1],[0,2,1],[1,1,3]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3489.minZeroArray(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {4, 3, 2, 1};
        int[][] queries = UtUtils.stringToInts2("[[1,3,2],[0,2,1]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution3489.minZeroArray(nums, queries));
    }

    @Test
    public void example3() {
        int[] nums = {1, 2, 3, 2, 1};
        int[][] queries = UtUtils.stringToInts2("[[0,1,1],[1,2,1],[2,3,2],[3,4,1],[4,4,1]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3489.minZeroArray(nums, queries));
    }

    @Test
    public void example4() {
        int[] nums = {1, 2, 3, 2, 6};
        int[][] queries = UtUtils.stringToInts2("[[0,1,1],[0,2,1],[1,4,2],[4,4,4],[3,4,1],[4,4,5]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3489.minZeroArray(nums, queries));
    }
}