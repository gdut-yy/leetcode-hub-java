import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3919Tests {
    private final Solution3919 solution3919 = new Solution3919();

    @Test
    public void example1() {
        int[] nums = {-5, -2, 3};
        int[][] queries = UtUtils.stringToInts2("[[0,2],[2,0],[1,2]]");
        int[] expected = {6, 2, 5};
        Assertions.assertArrayEquals(expected, solution3919.minCost(nums, queries));
    }

    @Test
    public void example2() {
        int[] nums = {0, 2, 3, 9};
        int[][] queries = UtUtils.stringToInts2("[[3,0],[1,2],[2,0]]");
        int[] expected = {4, 1, 3};
        Assertions.assertArrayEquals(expected, solution3919.minCost(nums, queries));
    }
}