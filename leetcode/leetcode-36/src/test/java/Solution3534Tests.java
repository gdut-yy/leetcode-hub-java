import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3534Tests {
    private final Solution3534 solution3534 = new Solution3534();

    @Test
    public void example1() {
        int n = 5;
        int[] nums = {1, 8, 3, 4, 2};
        int maxDiff = 3;
        int[][] queries = UtUtils.stringToInts2("[[0,3],[2,4]]");
        int[] expected = {1, 1};
        Assertions.assertArrayEquals(expected, solution3534.pathExistenceQueries(n, nums, maxDiff, queries));
    }

    @Test
    public void example2() {
        int n = 5;
        int[] nums = {5, 3, 1, 9, 10};
        int maxDiff = 2;
        int[][] queries = UtUtils.stringToInts2("[[0,1],[0,2],[2,3],[4,3]]");
        int[] expected = {1, 2, -1, 1};
        Assertions.assertArrayEquals(expected, solution3534.pathExistenceQueries(n, nums, maxDiff, queries));
    }

    @Test
    public void example3() {
        int n = 3;
        int[] nums = {3, 6, 1};
        int maxDiff = 1;
        int[][] queries = UtUtils.stringToInts2("[[0,0],[0,1],[1,2]]");
        int[] expected = {0, -1, -1};
        Assertions.assertArrayEquals(expected, solution3534.pathExistenceQueries(n, nums, maxDiff, queries));
    }
}