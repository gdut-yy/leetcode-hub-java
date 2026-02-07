import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3778Tests {
    private final SolutionP3778 solutionP3778 = new SolutionP3778();

    @Test
    public void example1() {
        int n = 5;
        int[][] edges = UtUtils.stringToInts2("[[0,1,2],[1,2,7],[2,3,7],[3,4,4]]");
        long expected = 13;
        Assertions.assertEquals(expected, solutionP3778.minCostExcludingMax(n, edges));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1],[1,2,1],[0,2,50000]]");
        long expected = 0;
        Assertions.assertEquals(expected, solutionP3778.minCostExcludingMax(n, edges));
    }
}