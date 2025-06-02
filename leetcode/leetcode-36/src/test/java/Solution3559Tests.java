import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3559Tests {
    private final Solution3559 solution3559 = new Solution3559();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[1,2]]");
        int[][] queries = UtUtils.stringToInts2("[[1,1],[1,2]]");
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution3559.assignEdgeWeights(edges, queries));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[1,2],[1,3],[3,4],[3,5]]");
        int[][] queries = UtUtils.stringToInts2("[[1,4],[3,4],[2,5]]");
        int[] expected = {2, 1, 4};
        Assertions.assertArrayEquals(expected, solution3559.assignEdgeWeights(edges, queries));
    }
}