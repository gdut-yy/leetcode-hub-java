import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3653Tests {
    private final Solution3653 solution3653 = new Solution3653();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1};
        int[][] queries = UtUtils.stringToInts2("[[0,2,1,4]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3653.xorAfterQueries(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {2, 3, 1, 5, 4};
        int[][] queries = UtUtils.stringToInts2("[[1,4,2,3],[0,2,1,2]]");
        int expected = 31;
        Assertions.assertEquals(expected, solution3653.xorAfterQueries(nums, queries));
    }
}