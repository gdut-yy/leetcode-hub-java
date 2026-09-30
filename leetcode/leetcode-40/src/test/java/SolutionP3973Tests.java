import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3973Tests {
    private final SolutionP3973 solutionP3973 = new SolutionP3973();

    @Test
    public void example1() {
        int n = 3;
        int[] parent = {-1, 0, 0};
        int[][] gates = UtUtils.stringToInts2("[[1,0,1],[0,1,1],[1,1,0]]");
        int[][] queries = UtUtils.stringToInts2("[[1,0,2,0],[1,1,2,0],[1,0,2,1]]");
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3973.distinctPaths(n, parent, gates, queries));
    }

    @Test
    public void example2() {
        int n = 3;
        int[] parent = {-1, 0, 1};
        int[][] gates = UtUtils.stringToInts2("[[0,1,2],[1,0,1],[0,0,3]]");
        int[][] queries = UtUtils.stringToInts2("[[2,0,1,0],[2,1,0,0],[1,1,2,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3973.distinctPaths(n, parent, gates, queries));
    }
}
