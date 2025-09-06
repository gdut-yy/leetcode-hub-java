import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolutionP3565Tests {
    private final SolutionP3565 solutionP3565 = new SolutionP3565();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[0,0,0],[0,1,2]]");
        int k = 2;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[0,0],[1,0],[1,1],[1,2],[0,2],[0,1]]");
        Assertions.assertEquals(expected, solutionP3565.findPath(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,0,4],[3,0,2]]");
        int k = 4;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[]");
        Assertions.assertEquals(expected, solutionP3565.findPath(grid, k));
    }
}