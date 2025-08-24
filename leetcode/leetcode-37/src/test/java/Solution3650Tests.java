import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3650Tests {
    private final Solution3650 solution3650 = new Solution3650();

    @Test
    public void example1() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1,3],[3,1,1],[2,3,4],[0,2,2]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution3650.minCost(n, edges));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,2,1],[2,1,1],[1,3,1],[2,3,3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3650.minCost(n, edges));
    }
}