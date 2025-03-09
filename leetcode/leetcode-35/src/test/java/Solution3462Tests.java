import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3462Tests {
    private final Solution3462 solution3462 = new Solution3462();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,2],[3,4]]");
        int[] limits = {1, 2};
        int k = 2;
        long expected = 7;
        Assertions.assertEquals(expected, solution3462.maxSum(grid, limits, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[5,3,7],[8,2,6]]");
        int[] limits = {2, 2};
        int k = 3;
        long expected = 21;
        Assertions.assertEquals(expected, solution3462.maxSum(grid, limits, k));
    }
}