import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3772Tests {
    private final Solution3772 solution3772 = new Solution3772();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[] good = {1, 0, 1};
        int[] expected = {1, 1, 1};
        Assertions.assertArrayEquals(expected, solution3772.maxSubgraphScore(n, edges, good));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[1,0],[1,2],[1,3],[3,4]]");
        int[] good = {0, 1, 0, 1, 1};
        int[] expected = {2, 3, 2, 3, 3};
        Assertions.assertArrayEquals(expected, solution3772.maxSubgraphScore(n, edges, good));
    }

    @Test
    public void example3() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[0,1]]");
        int[] good = {0, 0};
        int[] expected = {-1, -1};
        Assertions.assertArrayEquals(expected, solution3772.maxSubgraphScore(n, edges, good));
    }
}