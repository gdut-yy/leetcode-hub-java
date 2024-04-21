import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100290Tests {
    private final Solution100290 solution100290 = new Solution100290();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,2],[1,0,2]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution100290.minimumOperations(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[0,0,0]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution100290.minimumOperations(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1],[2],[3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution100290.minimumOperations(grid));
    }
}