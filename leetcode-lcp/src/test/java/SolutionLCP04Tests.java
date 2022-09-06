import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP04Tests {
    private final SolutionLCP04 solutionLCP04 = new SolutionLCP04();

    @Test
    public void example1() {
        int n = 2;
        int m = 3;
        int[][] broken = UtUtils.stringToInts2("[[1, 0], [1, 1]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP04.domino(n, m, broken));
    }

    @Test
    public void example2() {
        int n = 3;
        int m = 3;
        int[][] broken = UtUtils.stringToInts2("[]");
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP04.domino(n, m, broken));
    }
}
