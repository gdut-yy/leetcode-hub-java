import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3402Tests {
    private final Solution3402 solution3402 = new Solution3402();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[3,2],[1,3],[3,4],[0,1]]");
        int expected = 15;
        Assertions.assertEquals(expected, solution3402.minimumOperations(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[3,2,1],[2,1,0],[1,2,3]]");
        int expected = 12;
        Assertions.assertEquals(expected, solution3402.minimumOperations(grid));
    }
}