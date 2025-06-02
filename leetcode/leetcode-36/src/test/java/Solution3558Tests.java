import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3558Tests {
    private final Solution3558 solution3558 = new Solution3558();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[1,2]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution3558.assignEdgeWeights(edges));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[1,2],[1,3],[3,4],[3,5]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution3558.assignEdgeWeights(edges));
    }
}