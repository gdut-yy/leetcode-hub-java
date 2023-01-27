import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution711Tests {
    private final Solution711 solution711 = new Solution711();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0,0,0],[1,0,0,0,0],[0,0,0,0,1],[0,0,0,1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution711.numDistinctIslands2(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution711.numDistinctIslands2(grid));
    }
}