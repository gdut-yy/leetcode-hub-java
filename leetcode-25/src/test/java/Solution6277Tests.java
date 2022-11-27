import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6277Tests {
    private final Solution6277 solution6277 = new Solution6277();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,1],[1,0,1],[0,0,1]]");
        int[][] expected = UtUtils.stringToInts2("[[0,0,4],[0,0,4],[-2,-2,2]]");
        Assertions.assertArrayEquals(expected, solution6277.onesMinusZeros(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,1,1]]");
        int[][] expected = UtUtils.stringToInts2("[[5,5,5],[5,5,5]]");
        Assertions.assertArrayEquals(expected, solution6277.onesMinusZeros(grid));
    }
}
