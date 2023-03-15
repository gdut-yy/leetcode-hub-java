import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0107Tests {
    private final SolutionI0107 solutionI0107 = new SolutionI0107();

    @Test
    public void example1() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] expected = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        solutionI0107.rotate(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    @Test
    public void example2() {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        int[][] expected = {
                {15, 13, 2, 5},
                {14, 3, 4, 1},
                {12, 6, 8, 9},
                {16, 7, 10, 11}
        };
        solutionI0107.rotate(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }
}
