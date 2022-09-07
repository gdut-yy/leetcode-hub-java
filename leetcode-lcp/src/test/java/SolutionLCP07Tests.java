import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP07Tests {
    private final SolutionLCP07 solutionLCP07 = new SolutionLCP07();

    @Test
    public void example1() {
        int n = 5;
        int[][] relation = UtUtils.stringToInts2("[[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]]");
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP07.numWays(n, relation, k));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] relation = UtUtils.stringToInts2("[[0,2],[2,1]]");
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP07.numWays(n, relation, k));
    }
}
