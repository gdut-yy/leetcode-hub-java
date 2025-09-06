import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3665Tests {
    private final Solution3665 solution3665 = new Solution3665();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,0],[0,0,1],[1,0,0]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution3665.uniquePaths(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,0],[0,0]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3665.uniquePaths(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[0,1,1],[1,1,0]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3665.uniquePaths(grid));
    }
}