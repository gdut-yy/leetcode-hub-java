import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6054Tests {
    private final Solution6054 solution6054 = new Solution6054();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution6054.maximumMinutes(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,0,0],[0,1,2,0],[0,2,0,0]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution6054.maximumMinutes(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,0],[2,2,0],[1,2,0]]");
        int expected = 1000000000;
        Assertions.assertEquals(expected, solution6054.maximumMinutes(grid));
    }

}
