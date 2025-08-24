import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3651Tests {
    private final Solution3651 solution3651 = new Solution3651();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,3,3],[2,5,4],[4,3,5]]");
        int k = 2;
        int expected = 7;
        Assertions.assertEquals(expected, solution3651.minCost(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,2],[2,3],[3,4]]");
        int k = 1;
        int expected = 9;
        Assertions.assertEquals(expected, solution3651.minCost(grid, k));
    }
}