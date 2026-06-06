import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3898Tests {
    private final Solution3898 solution3898 = new Solution3898();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[0,1,1],[1,0,1],[1,1,0]]");
        int[] expected = {2, 2, 2};
        Assertions.assertArrayEquals(expected, solution3898.findDegrees(matrix));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[0,1,0],[1,0,0],[0,0,0]]");
        int[] expected = {1, 1, 0};
        Assertions.assertArrayEquals(expected, solution3898.findDegrees(matrix));
    }

    @Test
    public void example3() {
        int[][] matrix = UtUtils.stringToInts2("[[0]]");
        int[] expected = {0};
        Assertions.assertArrayEquals(expected, solution3898.findDegrees(matrix));
    }
}