import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5925Tests {
    private final Solution5925 solution5925 = new Solution5925();

    @Test
    public void example1() {
        int[][] grid = {{0, 1, 1, 0}, {1, 1, 1, 1}};
        int expected = 2;
        Assertions.assertEquals(expected, solution5925.countPyramids(grid));
    }

    @Test
    public void example2() {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}};
        int expected = 2;
        Assertions.assertEquals(expected, solution5925.countPyramids(grid));
    }

    @Test
    public void example3() {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        int expected = 0;
        Assertions.assertEquals(expected, solution5925.countPyramids(grid));
    }

    @Test
    public void example4() {
        int[][] grid = {{1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {0, 1, 0, 0, 1}};
        int expected = 13;
        Assertions.assertEquals(expected, solution5925.countPyramids(grid));
    }
}
