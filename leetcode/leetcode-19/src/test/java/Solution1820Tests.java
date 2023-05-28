import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1820Tests {
    private final Solution1820 solution1820 = new Solution1820();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,0,1],[0,0,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1820.maximumInvitations(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,1,0],[1,0,0,0],[0,0,1,0],[1,1,1,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution1820.maximumInvitations(grid));
    }
}