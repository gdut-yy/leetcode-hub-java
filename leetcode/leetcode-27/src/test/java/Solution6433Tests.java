import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6433Tests {
    private final Solution6433 solution6433 = new Solution6433();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution6433.maxMoves(grid));
        Assertions.assertEquals(expected, solution6433.maxMoves2(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[3,2,4],[2,1,9],[1,1,7]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution6433.maxMoves(grid));
        Assertions.assertEquals(expected, solution6433.maxMoves2(grid));
    }
}