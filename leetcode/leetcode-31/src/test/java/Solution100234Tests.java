import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100234Tests {
    private final Solution100234 solution100234 = new Solution100234();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,2],[1,1,0],[0,1,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution100234.minimumOperationsToWriteY(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,0,1,0],[2,1,0,1,2],[2,2,2,0,1],[2,2,2,2,2],[2,1,2,2,2]]");
        int expected = 12;
        Assertions.assertEquals(expected, solution100234.minimumOperationsToWriteY(grid));
    }
}