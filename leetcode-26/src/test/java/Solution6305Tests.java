import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6305Tests {
    private final Solution6305 solution6305 = new Solution6305();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,0,0],[1,1,1]]");
        Assertions.assertTrue(solution6305.isPossibleToCutPath(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,0,1],[1,1,1]]");
        Assertions.assertFalse(solution6305.isPossibleToCutPath(grid));
    }
}