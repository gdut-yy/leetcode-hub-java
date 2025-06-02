import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3567Tests {
    private final Solution3567 solution3567 = new Solution3567();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,8],[3,-2]]");
        int k = 2;
        int[][] expected = UtUtils.stringToInts2("[[2]]");
        Assertions.assertArrayEquals(expected, solution3567.minAbsDiff(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[3,-1]]");
        int k = 1;
        int[][] expected = UtUtils.stringToInts2("[[0,0]]");
        Assertions.assertArrayEquals(expected, solution3567.minAbsDiff(grid, k));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,-2,3],[2,3,5]]");
        int k = 2;
        int[][] expected = UtUtils.stringToInts2("[[1,2]]");
        Assertions.assertArrayEquals(expected, solution3567.minAbsDiff(grid, k));
    }
}