import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6456Tests {
    private final Solution6456 solution6456 = new Solution6456();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[3,1],[3,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution6456.maxIncreasingCells(mat));
        Assertions.assertEquals(expected, solution6456.maxIncreasingCells2(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[1,1],[1,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution6456.maxIncreasingCells(mat));
        Assertions.assertEquals(expected, solution6456.maxIncreasingCells2(mat));
    }

    @Test
    public void example3() {
        int[][] mat = UtUtils.stringToInts2("[[3,1,6],[-9,5,7]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution6456.maxIncreasingCells(mat));
        Assertions.assertEquals(expected, solution6456.maxIncreasingCells2(mat));
    }
}