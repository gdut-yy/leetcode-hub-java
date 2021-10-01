import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0108Tests {
    private final SolutionI0108 solutionI0108 = new SolutionI0108();

    @Test
    public void example1() {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] expected = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        solutionI0108.setZeroes(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }

    @Test
    public void example2() {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        int[][] expected = {
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}
        };
        solutionI0108.setZeroes(matrix);
        Assertions.assertArrayEquals(expected, matrix);
    }
}
