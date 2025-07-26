import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3613Tests {
    private final Solution3613 solution3613 = new Solution3613();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1,4],[1,2,3],[1,3,2],[3,4,6]]");
        int k = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solution3613.minCost(n, edges, k));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1,5],[1,2,5],[2,3,5]]");
        int k = 1;
        int expected = 5;
        Assertions.assertEquals(expected, solution3613.minCost(n, edges, k));
    }
}