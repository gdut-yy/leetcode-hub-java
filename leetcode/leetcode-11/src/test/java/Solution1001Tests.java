import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1001Tests {
    private final Solution1001 solution1001 = new Solution1001();

    @Test
    public void example1() {
        int n = 5;
        int[][] lamps = UtUtils.stringToInts2("[[0,0],[4,4]]");
        int[][] queries = UtUtils.stringToInts2("[[1,1],[1,0]]");
        int[] expected = {1, 0};
        Assertions.assertArrayEquals(expected, solution1001.gridIllumination(n, lamps, queries));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] lamps = UtUtils.stringToInts2("[[0,0],[4,4]]");
        int[][] queries = UtUtils.stringToInts2("[[1,1],[1,1]]");
        int[] expected = {1, 1};
        Assertions.assertArrayEquals(expected, solution1001.gridIllumination(n, lamps, queries));
    }

    @Test
    public void example3() {
        int n = 5;
        int[][] lamps = UtUtils.stringToInts2("[[0,0],[0,4]]");
        int[][] queries = UtUtils.stringToInts2("[[0,4],[0,1],[1,4]]");
        int[] expected = {1, 1, 0};
        Assertions.assertArrayEquals(expected, solution1001.gridIllumination(n, lamps, queries));
    }
}