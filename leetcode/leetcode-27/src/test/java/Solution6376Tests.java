import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6376Tests {
    private final Solution6376 solution6376 = new Solution6376();

    @Test
    public void example1() {
        int[][] mat = UtUtils.stringToInts2("[[0,1],[1,0]]");
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution6376.rowAndMaximumOnes(mat));
    }

    @Test
    public void example2() {
        int[][] mat = UtUtils.stringToInts2("[[0,0,0],[0,1,1]]");
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution6376.rowAndMaximumOnes(mat));
    }

    @Test
    public void example3() {
        int[][] mat = UtUtils.stringToInts2("[[0,0],[1,1],[0,0]]");
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution6376.rowAndMaximumOnes(mat));
    }
}