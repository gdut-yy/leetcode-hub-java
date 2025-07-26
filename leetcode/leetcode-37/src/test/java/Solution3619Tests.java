import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3619Tests {
    private final Solution3619 solution3619 = new Solution3619();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]]");
        int k = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution3619.countIslands(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[3,0,3,0], [0,3,0,3], [3,0,3,0]]");
        int k = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solution3619.countIslands(grid, k));
    }
}