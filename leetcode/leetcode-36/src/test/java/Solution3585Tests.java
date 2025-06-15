import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3585Tests {
    private final Solution3585 solution3585 = new Solution3585();

    @Test
    public void example1() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[0,1,7]]");
        int[][] queries = UtUtils.stringToInts2("[[1,0],[0,1]]");
        int[] expected = {0, 1};
        Assertions.assertArrayEquals(expected, solution3585.findMedian(n, edges, queries));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,2],[2,0,4]]");
        int[][] queries = UtUtils.stringToInts2("[[0,1],[2,0],[1,2]]");
        int[] expected = {1, 0, 2};
        Assertions.assertArrayEquals(expected, solution3585.findMedian(n, edges, queries));
    }

    @Test
    public void example3() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1,2],[0,2,5],[1,3,1],[2,4,3]]");
        int[][] queries = UtUtils.stringToInts2("[[3,4],[1,2]]");
        int[] expected = {2, 2};
        Assertions.assertArrayEquals(expected, solution3585.findMedian(n, edges, queries));
    }
}