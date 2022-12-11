import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6260Tests {
    private final Solution6260 solution6260 = new Solution6260();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,3],[2,5,7],[3,5,1]]");
        int[] queries = {5, 6, 2};
        int[] expected = {5, 8, 1};
        Assertions.assertArrayEquals(expected, solution6260.maxPoints(grid, queries));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[5,2,1],[1,1,2]]");
        int[] queries = {3};
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution6260.maxPoints(grid, queries));
    }
}
