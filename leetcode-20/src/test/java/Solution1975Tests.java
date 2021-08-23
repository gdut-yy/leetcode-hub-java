import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1975Tests {
    private final Solution1975 solution1975 = new Solution1975();

    @Test
    public void example1() {
        int[][] matrix = {{1, -1}, {-1, 1}};
        long expected = 4;
        Assertions.assertEquals(expected, solution1975.maxMatrixSum(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = {{1, 2, 3}, {-1, -2, -3}, {1, 2, 3}};
        long expected = 16;
        Assertions.assertEquals(expected, solution1975.maxMatrixSum(matrix));
    }

    // 补充用例
    @Test
    public void example3() {
        int[][] matrix = {{-1, 0, -1}, {-2, 1, 3}, {3, 2, 2}};
        long expected = 15;
        Assertions.assertEquals(expected, solution1975.maxMatrixSum(matrix));
    }

    @Test
    public void example4() {
        int[][] matrix = {{2, 9, 3}, {5, 4, -4}, {1, 7, 1}};
        long expected = 34;
        Assertions.assertEquals(expected, solution1975.maxMatrixSum(matrix));
    }
}
