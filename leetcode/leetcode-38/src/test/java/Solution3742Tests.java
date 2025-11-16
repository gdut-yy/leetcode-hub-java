import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3742Tests {
    private final Solution3742 solution3742 = new Solution3742();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0, 1],[2, 0]]");
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3742.maxPathScore(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[0, 1],[1, 2]]");
        int k = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solution3742.maxPathScore(grid, k));
    }
}