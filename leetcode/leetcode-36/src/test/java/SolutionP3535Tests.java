import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3535Tests {
    private final SolutionP3535 solutionP3535 = new SolutionP3535();

    @Test
    public void example1() {
        int[][] conversions = UtUtils.stringToInts2("[[0,1,2],[0,2,6]]");
        int[][] queries = UtUtils.stringToInts2("[[1,2],[1,0]]");
        int[] expected = {3, 500000004};
        Assertions.assertArrayEquals(expected, solutionP3535.queryConversions(conversions, queries));
    }

    @Test
    public void example2() {
        int[][] conversions = UtUtils.stringToInts2("[[0,1,2],[0,2,6],[0,3,8],[2,4,2],[2,5,4],[3,6,3]]");
        int[][] queries = UtUtils.stringToInts2("[[1,2],[0,4],[6,5],[4,6],[6,1]]");
        int[] expected = {3, 12, 1, 2, 83333334};
        Assertions.assertArrayEquals(expected, solutionP3535.queryConversions(conversions, queries));
    }
}