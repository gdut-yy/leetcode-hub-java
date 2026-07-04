import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3928Tests {
    private final Solution3928 solution3928 = new Solution3928();

    @Test
    public void example1() {
        int n = 2;
        int[] prices = {8, 3};
        int[][] roads = UtUtils.stringToInts2("[[0,1,1,2]]");
        int[] expected = {6, 3};
        Assertions.assertArrayEquals(expected, solution3928.minCost(n, prices, roads));
    }

    @Test
    public void example2() {
        int n = 3;
        int[] prices = {9, 4, 6};
        int[][] roads = UtUtils.stringToInts2("[[0,1,1,3],[1,2,4,2]]");
        int[] expected = {8, 4, 6};
        Assertions.assertArrayEquals(expected, solution3928.minCost(n, prices, roads));
    }

    @Test
    public void example3() {
        int n = 3;
        int[] prices = {10, 11, 1};
        int[][] roads = UtUtils.stringToInts2("[[0,2,1,3],[1,2,3,4],[0,1,5,2]]");
        int[] expected = {5, 11, 1};
        Assertions.assertArrayEquals(expected, solution3928.minCost(n, prices, roads));
    }
}