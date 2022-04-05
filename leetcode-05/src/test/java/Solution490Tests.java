import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution490Tests {
    private final Solution490 solution490 = new Solution490();

    @Test
    public void example1() {
        int[][] maze = UtUtils.stringToInts2("[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]");
        int[] start = {0, 4};
        int[] destination = {4, 4};
        Assertions.assertTrue(solution490.hasPath(maze, start, destination));
    }

    @Test
    public void example2() {
        int[][] maze = UtUtils.stringToInts2("[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]");
        int[] start = {0, 4};
        int[] destination = {3, 2};
        Assertions.assertFalse(solution490.hasPath(maze, start, destination));
    }

    @Test
    public void example3() {
        int[][] maze = UtUtils.stringToInts2("[[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]");
        int[] start = {4, 3};
        int[] destination = {0, 1};
        Assertions.assertFalse(solution490.hasPath(maze, start, destination));
    }
}
