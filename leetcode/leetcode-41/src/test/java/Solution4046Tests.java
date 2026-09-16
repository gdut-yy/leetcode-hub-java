import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4046Tests {
    private final Solution4046 solution4046 = new Solution4046();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[2,7,3],[1,4,5]]");
        int k = 1;
        int expected = 12;
        Assertions.assertEquals(expected, solution4046.minCost(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[4,1,9],[3,2,5],[4,8,6]]");
        int k = 2;
        int expected = 20;
        Assertions.assertEquals(expected, solution4046.minCost(grid, k));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,9],[3,4]]");
        int k = 0;
        int expected = -1;
        Assertions.assertEquals(expected, solution4046.minCost(grid, k));
    }
}