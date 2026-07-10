import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3970Tests {
    private final Solution3970 solution = new Solution3970();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,2,1],[0,2,3]]");
        String labels = "aab";
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solution.shortestPath(n, edges, labels, k));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,2,1],[0,2,3]]");
        String labels = "aab";
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution.shortestPath(n, edges, labels, k));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,2,1]]");
        String labels = "aaa";
        int k = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution.shortestPath(n, edges, labels, k));
    }
}