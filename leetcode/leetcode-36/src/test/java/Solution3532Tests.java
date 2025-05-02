import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3532Tests {
    private final Solution3532 solution3532 = new Solution3532();

    @Test
    public void example1() {
        int n = 2;
        int[] nums = {1, 3};
        int maxDiff = 1;
        int[][] queries = UtUtils.stringToInts2("[[0,0],[0,1]]");
        boolean[] expected = {true, false};
        Assertions.assertArrayEquals(expected, solution3532.pathExistenceQueries(n, nums, maxDiff, queries));
    }

    @Test
    public void example2() {
        int n = 4;
        int[] nums = {2, 5, 6, 8};
        int maxDiff = 2;
        int[][] queries = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[2,3]]");
        boolean[] expected = {false, false, true, true};
        Assertions.assertArrayEquals(expected, solution3532.pathExistenceQueries(n, nums, maxDiff, queries));
    }
}