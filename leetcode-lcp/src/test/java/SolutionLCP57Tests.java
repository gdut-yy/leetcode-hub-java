import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP57Tests {
    private final SolutionLCP57 solutionLcp57 = new SolutionLCP57();

    @Test
    public void example1() {
        int[][] moles = UtUtils.stringToInts2("[[1,1,0],[2,0,1],[4,2,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionLcp57.getMaximumNumber(moles));
    }

    @Test
    public void example2() {
        int[][] moles = UtUtils.stringToInts2("[[2,0,2],[5,2,0],[4,1,0],[1,2,1],[3,0,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionLcp57.getMaximumNumber(moles));
    }

    @Test
    public void example3() {
        int[][] moles = UtUtils.stringToInts2("[[0,1,0],[0,0,1]]");
        int expected = 0;
        Assertions.assertEquals(expected, solutionLcp57.getMaximumNumber(moles));
    }
}
