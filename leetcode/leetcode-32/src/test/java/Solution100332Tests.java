import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100332Tests {
    private final Solution100332 solution100332 = new Solution100332();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,1],[1,1,1]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution100332.minimumSum(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,1,0],[0,1,0,1]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution100332.minimumSum(grid));
    }
}