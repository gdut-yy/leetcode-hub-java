import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3393Tests {
    private final Solution3393 solution3393 = new Solution3393();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[2, 1, 5], [7, 10, 0], [12, 6, 4]]");
        int k = 11;
        int expected = 3;
        Assertions.assertEquals(expected, solution3393.countPathsWithXorValue(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1, 3, 3, 3], [0, 3, 3, 2], [3, 0, 1, 1]]");
        int k = 2;
        int expected = 5;
        Assertions.assertEquals(expected, solution3393.countPathsWithXorValue(grid, k));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1, 1, 1, 2], [3, 0, 3, 2], [3, 0, 2, 2]]");
        int k = 10;
        int expected = 0;
        Assertions.assertEquals(expected, solution3393.countPathsWithXorValue(grid, k));
    }
}