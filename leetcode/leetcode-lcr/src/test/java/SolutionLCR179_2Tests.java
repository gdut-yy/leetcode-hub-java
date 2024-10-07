import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR179_2Tests {
    private final SolutionLCR180 solutionLCR180 = new SolutionLCR180();

    @Test
    public void example1() {
        int target = 9;
        int[][] expected = UtUtils.stringToInts2("[[2,3,4],[4,5]]");
        Assertions.assertArrayEquals(expected, solutionLCR180.fileCombination(target));
    }

    @Test
    public void example2() {
        int target = 15;
        int[][] expected = UtUtils.stringToInts2("[[1,2,3,4,5],[4,5,6],[7,8]]");
        Assertions.assertArrayEquals(expected, solutionLCR180.fileCombination(target));
    }
}
