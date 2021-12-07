import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1034Tests {
    private final Solution1034 solution1034 = new Solution1034();

    @Test
    public void example1() {
        int[][] grid = {{1, 1}, {1, 2}};
        int row = 0;
        int col = 0;
        int color = 3;
        int[][] expected = {{3, 3}, {3, 2}};
        Assertions.assertArrayEquals(expected, solution1034.colorBorder(grid, row, col, color));
    }

    @Test
    public void example2() {
        int[][] grid = {{1, 2, 2}, {2, 3, 2}};
        int row = 0;
        int col = 1;
        int color = 3;
        int[][] expected = {{1, 3, 3}, {2, 3, 3}};
        Assertions.assertArrayEquals(expected, solution1034.colorBorder(grid, row, col, color));
    }

    @Test
    public void example3() {
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int row = 1;
        int col = 1;
        int color = 2;
        int[][] expected = {{2, 2, 2}, {2, 1, 2}, {2, 2, 2}};
        Assertions.assertArrayEquals(expected, solution1034.colorBorder(grid, row, col, color));
    }

    // 补充用例
    @Test
    public void example4() {
        int[][] grid = {{1, 2, 1, 2, 1, 2}, {2, 2, 2, 2, 1, 2}, {1, 2, 2, 2, 1, 2}};
        int row = 1;
        int col = 3;
        int color = 1;
        int[][] expected = {{1, 1, 1, 1, 1, 2}, {1, 2, 1, 1, 1, 2}, {1, 1, 1, 1, 1, 2}};
        Assertions.assertArrayEquals(expected, solution1034.colorBorder(grid, row, col, color));
    }
}