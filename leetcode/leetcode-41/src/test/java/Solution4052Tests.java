import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4052Tests {
    private final Solution4052 solution4052 = new Solution4052();

    @Test
    public void example1() {
        int n = 2;
        int[][] grid = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int[] rowShift = {1, 0};
        int[] colShift = {0, 1};
        int[][] expected = UtUtils.stringToInts2("[[2,4],[3,1]]");
        Assertions.assertArrayEquals(expected, solution4052.cyclicShift(n, grid, rowShift, colShift));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] grid = UtUtils.stringToInts2("[[1,2,3],[4,5,6],[7,8,9]]");
        int[] rowShift = {1, 2, 0};
        int[] colShift = {2, 2, 1};
        int[][] expected = UtUtils.stringToInts2("[[7,8,5],[2,3,9],[6,4,1]]");
        Assertions.assertArrayEquals(expected, solution4052.cyclicShift(n, grid, rowShift, colShift));
    }
}