import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution694Tests {
    private final Solution694 solution694 = new Solution694();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution694.numDistinctIslands(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution694.numDistinctIslands(grid));
    }
}
