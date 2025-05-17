import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3548Tests {
    private final Solution3548 solution3548 = new Solution3548();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,4],[2,3]]");
        Assertions.assertTrue(solution3548.canPartitionGrid(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,2],[3,4]]");
        Assertions.assertTrue(solution3548.canPartitionGrid(grid));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1,2,4],[2,3,5]]");
        Assertions.assertFalse(solution3548.canPartitionGrid(grid));
    }

    @Test
    public void example4() {
        int[][] grid = UtUtils.stringToInts2("[[4,1,8],[3,2,6]]");
        Assertions.assertFalse(solution3548.canPartitionGrid(grid));
    }
}