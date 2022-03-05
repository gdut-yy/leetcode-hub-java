import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1129Tests {
    private final Solution1129 solution1129 = new Solution1129();

    @Test
    public void example1() {
        int n = 3;
        int[][] redEdges = {{0, 1}, {1, 2}};
        int[][] blueEdges = {};
        int[] expected = {0, 1, -1};
        Assertions.assertArrayEquals(expected, solution1129.shortestAlternatingPaths(n, redEdges, blueEdges));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] redEdges = {{0, 1}};
        int[][] blueEdges = {{2, 1}};
        int[] expected = {0, 1, -1};
        Assertions.assertArrayEquals(expected, solution1129.shortestAlternatingPaths(n, redEdges, blueEdges));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] redEdges = {{1, 0}};
        int[][] blueEdges = {{2, 1}};
        int[] expected = {0, -1, -1};
        Assertions.assertArrayEquals(expected, solution1129.shortestAlternatingPaths(n, redEdges, blueEdges));
    }

    @Test
    public void example4() {
        int n = 3;
        int[][] redEdges = {{0, 1}};
        int[][] blueEdges = {{1, 2}};
        int[] expected = {0, 1, 2};
        Assertions.assertArrayEquals(expected, solution1129.shortestAlternatingPaths(n, redEdges, blueEdges));
    }

    @Test
    public void example5() {
        int n = 3;
        int[][] redEdges = {{0, 1}, {0, 2}};
        int[][] blueEdges = {{1, 0}};
        int[] expected = {0, 1, 1};
        Assertions.assertArrayEquals(expected, solution1129.shortestAlternatingPaths(n, redEdges, blueEdges));
    }
}
