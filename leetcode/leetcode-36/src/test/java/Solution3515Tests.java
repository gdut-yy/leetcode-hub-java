import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3515Tests {
    private final Solution3515 solution3515 = new Solution3515();

    @Test
    public void example1() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[1,2,7]]");
        int[][] queries = UtUtils.stringToInts2("[[2,2],[1,1,2,4],[2,2]]");
        int[] expected = {7, 4};
        Assertions.assertArrayEquals(expected, solution3515.treeQueries(n, edges, queries));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[1,2,2],[1,3,4]]");
        int[][] queries = UtUtils.stringToInts2("[[2,1],[2,3],[1,1,3,7],[2,2],[2,3]]");
        int[] expected = {0, 4, 2, 7};
        Assertions.assertArrayEquals(expected, solution3515.treeQueries(n, edges, queries));
    }

    @Test
    public void example3() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[1,2,2],[2,3,1],[3,4,5]]");
        int[][] queries = UtUtils.stringToInts2("[[2,4],[2,3],[1,2,3,3],[2,2],[2,3]]");
        int[] expected = {8, 3, 2, 5};
        Assertions.assertArrayEquals(expected, solution3515.treeQueries(n, edges, queries));
    }
}