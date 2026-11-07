import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4100Tests {
    private final Solution4100 solution4100 = new Solution4100();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,4],[0,2,6],[0,3,3],[3,4,5]]");
        int[] values = {3, 1, 7, 1, 3};
        int expected = 7;
        Assertions.assertEquals(expected, solution4100.minActivationCost(edges, values));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,5],[1,2,10]]");
        int[] values = {1, 7, 3};
        int expected = 5;
        Assertions.assertEquals(expected, solution4100.minActivationCost(edges, values));
    }

    @Test
    public void example3() {
        int[][] edges = UtUtils.stringToInts2("[[0,1,5],[0,2,7],[0,3,9]]");
        int[] values = {1, 3, 5, 9};
        int expected = -1;
        Assertions.assertEquals(expected, solution4100.minActivationCost(edges, values));
    }
}
