import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6333Tests {
    private final Solution6333 solution6333 = new Solution6333();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1],[22],[333]]");
        int[] expected = {3};
        Assertions.assertArrayEquals(expected, solution6333.findColumnWidth(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[-15,1,3],[15,7,12],[5,6,-2]]");
        int[] expected = {3, 1, 2};
        Assertions.assertArrayEquals(expected, solution6333.findColumnWidth(grid));
    }
}