import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2850Tests {
    private final Solution2850 solution2850 = new Solution2850();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,0],[1,1,1],[1,2,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2850.minimumMoves(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,3,0],[1,0,0],[1,0,3]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution2850.minimumMoves(grid));
    }
}