import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution317Tests {
    private final Solution317 solution317 = new Solution317();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution317.shortestDistance(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution317.shortestDistance(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution317.shortestDistance(grid));
    }
}
