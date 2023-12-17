import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100149Tests {
    private final Solution100149 solution100149 = new Solution100149();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,3],[2,2]]");
        int[] expected = {2, 4};
        Assertions.assertArrayEquals(expected, solution100149.findMissingAndRepeatedValues(grid));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[9,1,7],[8,9,2],[3,4,6]]");
        int[] expected = {9, 5};
        Assertions.assertArrayEquals(expected, solution100149.findMissingAndRepeatedValues(grid));
    }
}