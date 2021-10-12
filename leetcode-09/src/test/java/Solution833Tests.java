import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution833Tests {
    private final Solution833 solution833 = new Solution833();

    @Test
    public void example1() {
        int[][] grid = {{2}};
        int expected = 5;
        Assertions.assertEquals(expected, solution833.projectionArea(grid));
    }

    @Test
    public void example2() {
        int[][] grid = {{1, 2}, {3, 4}};
        int expected = 17;
        Assertions.assertEquals(expected, solution833.projectionArea(grid));
    }

    @Test
    public void example3() {
        int[][] grid = {{1, 0}, {0, 2}};
        int expected = 8;
        Assertions.assertEquals(expected, solution833.projectionArea(grid));
    }

    @Test
    public void example4() {
        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int expected = 14;
        Assertions.assertEquals(expected, solution833.projectionArea(grid));
    }

    @Test
    public void example5() {
        int[][] grid = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        int expected = 21;
        Assertions.assertEquals(expected, solution833.projectionArea(grid));
    }
}
