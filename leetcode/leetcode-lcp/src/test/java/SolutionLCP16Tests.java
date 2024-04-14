import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP16Tests {
    private final SolutionLCP16 solutionLCP16 = new SolutionLCP16();

    @Test
    public void example1() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2],[0,2]]");
        int[] value = {1, 2, 3};
        int expected = 6;
        Assertions.assertEquals(expected, solutionLCP16.maxWeight(edges, value));
    }

    @Test
    public void example2() {
        int[][] edges = UtUtils.stringToInts2("[[0,2],[2,1]]");
        int[] value = {1, 2, 5};
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP16.maxWeight(edges, value));
    }

    @Test
    public void example3() {
        int[][] edges = UtUtils.stringToInts2("[[0,1],[0,2],[0,3],[0,4],[0,5],[1,3],[2,4],[2,5],[3,4],[3,5],[4,5]]");
        int[] value = {7, 8, 6, 8, 9, 7};
        int expected = 39;
        Assertions.assertEquals(expected, solutionLCP16.maxWeight(edges, value));
    }
}