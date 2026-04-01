import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3882Tests {
    private final Solution3882 solution3882 = new Solution3882();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution3882.minCost(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[6,7],[5,8]]");
        int expected = 9;
        Assertions.assertEquals(expected, solution3882.minCost(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[2,7,5]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution3882.minCost(grid));
    }
}