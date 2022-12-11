import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP35Tests {
    private final SolutionLCP35 solutionLCP35 = new SolutionLCP35();

    @Test
    public void example1() {
        int[][] paths = UtUtils.stringToInts2("[[1,3,3],[3,2,1],[2,1,3],[0,1,4],[3,0,5]]");
        int cnt = 6;
        int start = 1;
        int end = 0;
        int[] charge = {2, 10, 4, 1};
        int expected = 43;
        Assertions.assertEquals(expected, solutionLCP35.electricCarPlan(paths, cnt, start, end, charge));
    }

    @Test
    public void example2() {
        int[][] paths = UtUtils.stringToInts2("[[0,4,2],[4,3,5],[3,0,5],[0,1,5],[3,2,4],[1,2,8]]");
        int cnt = 8;
        int start = 0;
        int end = 2;
        int[] charge = {4, 1, 1, 3, 2};
        int expected = 38;
        Assertions.assertEquals(expected, solutionLCP35.electricCarPlan(paths, cnt, start, end, charge));
    }
}
