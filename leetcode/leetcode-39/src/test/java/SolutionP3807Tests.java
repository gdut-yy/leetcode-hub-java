import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3807Tests {
    private final SolutionP3807 solutionP3807 = new SolutionP3807();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,10],[1,2,10],[0,2,100]]");
        int k = 1;
        int expected = 100;
        Assertions.assertEquals(expected, solutionP3807.minCost(n, edges, k));
    }

    @Test
    public void example2() {
        int n = 6;
        int[][] edges = UtUtils.stringToInts2("[[0,2,5],[2,3,6],[3,4,7],[4,5,5],[0,1,10],[1,5,12],[0,3,9],[1,2,8],[2,4,11]]");
        int k = 2;
        int expected = 12;
        Assertions.assertEquals(expected, solutionP3807.minCost(n, edges, k));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,1]]");
        int k = 1;
        int expected = -1;
        Assertions.assertEquals(expected, solutionP3807.minCost(n, edges, k));
    }
}
