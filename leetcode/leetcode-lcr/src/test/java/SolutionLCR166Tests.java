import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR166Tests {
    private final SolutionLCR166 solutionLCR166 = new SolutionLCR166();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[1,3,1],[1,5,1],[4,2,1]]");
        int expected = 12;
        Assertions.assertEquals(expected, solutionLCR166.jewelleryValue(grid));
    }
}
