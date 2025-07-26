import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3620Tests {
    private final Solution3620 solution3620 = new Solution3620();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,5],[1,3,10],[0,2,3],[2,3,4]]");
        boolean[] online = {true, true, true, true};
        long k = 10;
        int expected = 3;
        Assertions.assertEquals(expected, solution3620.findMaxPathScore(edges, online, k));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,7],[1,4,5],[0,2,6],[2,3,6],[3,4,2],[2,4,6]]");
        boolean[] online = {true, true, true, false, true};
        long k = 12;
        int expected = 6;
        Assertions.assertEquals(expected, solution3620.findMaxPathScore(edges, online, k));
    }
}