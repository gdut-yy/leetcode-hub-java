import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3546Tests {
    private final Solution3546 solution3546 = new Solution3546();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,4],[2,3]]");
        Assertions.assertTrue(solution3546.canPartitionGrid(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,3],[2,4]]");
        Assertions.assertFalse(solution3546.canPartitionGrid(grid));
    }
}