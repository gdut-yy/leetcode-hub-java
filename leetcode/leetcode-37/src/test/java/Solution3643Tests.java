import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3643Tests {
    private final Solution3643 solution3643 = new Solution3643();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]");
        int x = 1;
        int y = 0;
        int k = 3;
        int[][] expected = UtUtils.stringToInts2("[[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]");
        Assertions.assertArrayEquals(expected, solution3643.reverseSubmatrix(grid, x, y, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[3,4,2,3],[2,3,4,2]]");
        int x = 0;
        int y = 2;
        int k = 2;
        int[][] expected = UtUtils.stringToInts2("[[3,4,4,2],[2,3,2,3]]");
        Assertions.assertArrayEquals(expected, solution3643.reverseSubmatrix(grid, x, y, k));
    }
}