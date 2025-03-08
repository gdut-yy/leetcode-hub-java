import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3459Tests {
    private final Solution3459 solution3459 = new Solution3459();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[2,2,1,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution3459.lenOfVDiagonal(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[2,2,2,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution3459.lenOfVDiagonal(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,2,2,2],[2,2,2,2,0],[2,0,0,0,0],[0,0,2,2,2],[2,0,0,2,0]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution3459.lenOfVDiagonal(grid));
    }

    @Test
    public void example4() {
        int[][] grid = UtUtils.stringToInts2("[[1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3459.lenOfVDiagonal(grid));
    }
}