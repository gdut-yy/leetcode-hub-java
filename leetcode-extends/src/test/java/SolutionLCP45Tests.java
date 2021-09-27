import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP45Tests {
    private final SolutionLCP45 solutionLCP45 = new SolutionLCP45();

    @Test
    public void example1() {
        int[] position = {0, 0};
        int[][] terrain = {{0, 0}, {0, 0}};
        int[][] obstacle = {{0, 0}, {0, 0}};
        int[][] expected = {{0, 1}, {1, 0}, {1, 1}};
        Assertions.assertArrayEquals(expected, solutionLCP45.bicycleYard(position, terrain, obstacle));
    }

    @Test
    public void example2() {
        int[] position = {1, 1};
        int[][] terrain = {{5, 0}, {0, 6}};
        int[][] obstacle = {{0, 6}, {7, 0}};
        int[][] expected = {{0, 1}};
        Assertions.assertArrayEquals(expected, solutionLCP45.bicycleYard(position, terrain, obstacle));
    }
}
