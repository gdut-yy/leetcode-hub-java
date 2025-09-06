import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3437Tests {
    private final SolutionP3437 solutionP3437 = new SolutionP3437();

    @Test
    public void example1() {
        int n = 4;
        int[][] expected = UtUtils.stringToInts2("[[1,2,3,4],[1,4,3,2],[2,1,4,3],[2,3,4,1],[3,2,1,4],[3,4,1,2],[4,1,2,3],[4,3,2,1]]");
        Assertions.assertArrayEquals(expected, solutionP3437.permute(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int[][] expected = UtUtils.stringToInts2("[[1,2],[2,1]]");
        Assertions.assertArrayEquals(expected, solutionP3437.permute(n));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] expected = UtUtils.stringToInts2("[[1,2,3],[3,2,1]]");
        Assertions.assertArrayEquals(expected, solutionP3437.permute(n));
    }
}