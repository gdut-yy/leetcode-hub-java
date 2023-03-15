import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0813Tests {
    private final SolutionI0813 solutionI0813 = new SolutionI0813();

    @Test
    public void example1() {
        int[][] box = UtUtils.stringToInts2("[[1, 1, 1], [2, 2, 2], [3, 3, 3]]");
        int expected = 6;
        Assertions.assertEquals(expected, solutionI0813.pileBox(box));
    }

    @Test
    public void example2() {
        int[][] box = UtUtils.stringToInts2("[[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]");
        int expected = 10;
        Assertions.assertEquals(expected, solutionI0813.pileBox(box));
    }
}
