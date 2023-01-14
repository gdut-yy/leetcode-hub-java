import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP54Tests {
    private final SolutionLCP54 solutionLCP54 = new SolutionLCP54();

    @Test
    public void example1() {
        int[] cost = {1, 2, 3, 4, 5, 6};
        int[][] roads = UtUtils.stringToInts2("[[0,1],[0,2],[1,3],[2,3],[1,2],[2,4],[2,5]]");
        long expected = 6;
        Assertions.assertEquals(expected, solutionLCP54.minimumCost(cost, roads));
    }

    @Test
    public void example2() {
        int[] cost = {3, 2, 1, 4};
        int[][] roads = UtUtils.stringToInts2("[[0,2],[2,3],[3,1]]");
        long expected = 2;
        Assertions.assertEquals(expected, solutionLCP54.minimumCost(cost, roads));
    }
}
