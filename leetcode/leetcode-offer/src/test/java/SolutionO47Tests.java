import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO47Tests {
    private final SolutionO47 solutionO47 = new SolutionO47();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,3,1],[1,5,1],[4,2,1]]");
        int expected = 12;
        Assertions.assertEquals(expected, solutionO47.maxValue(grid));
    }
}
