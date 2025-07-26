import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution803Tests {
    private final Solution803 solution803 = new Solution803();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0,0],[1,1,1,0]]");
        int[][] hits = UtUtils.stringToInts2("[[1,0]]");
        int[] expected = {2};
        Assertions.assertArrayEquals(expected, solution803.hitBricks(grid, hits));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,0,0],[1,1,0,0]]");
        int[][] hits = UtUtils.stringToInts2("[[1,1],[1,0]]");
        int[] expected = {0, 0};
        Assertions.assertArrayEquals(expected, solution803.hitBricks(grid, hits));
    }
}