import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP62Tests {
    private final SolutionLCP62 solutionLCP62 = new SolutionLCP62();

    @Test
    public void example1() {
        int[][] path = UtUtils.stringToInts2("[[0,1],[0,3],[1,3],[2,0],[2,3]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP62.transportationHub(path));
    }

    @Test
    public void example2() {
        int[][] path = UtUtils.stringToInts2("[[0,3],[1,0],[1,3],[2,0],[3,0],[3,2]]");
        int expected = -1;
        Assertions.assertEquals(expected, solutionLCP62.transportationHub(path));
    }
}
