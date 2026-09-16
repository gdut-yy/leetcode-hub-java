import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3989Tests {
    private final Solution3989 solution3989 = new Solution3989();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[-2,0,3]]");
        int limit = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3989.maxConsistentColumns(grid, limit));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,-1,1],[2,2,2]]");
        int limit = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3989.maxConsistentColumns(grid, limit));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[-5,5]]");
        int limit = 9;
        int expected = 1;
        Assertions.assertEquals(expected, solution3989.maxConsistentColumns(grid, limit));
    }
}