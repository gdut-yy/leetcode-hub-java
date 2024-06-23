import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100334Tests {
    private final Solution100334 solution100334 = new Solution100334();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,0],[1,0,1]]");
        int expected = 6;
        Assertions.assertEquals(expected, solution100334.minimumArea(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,0],[1,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution100334.minimumArea(grid));
    }
}