import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2608Tests {
    private final Solution2608 solution2608 = new Solution2608();

    @Test
    public void example1() {
        int n = 7;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[2,0],[3,4],[4,5],[5,6],[6,3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution2608.findShortestCycle(n, edges));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution2608.findShortestCycle(n, edges));
    }
}