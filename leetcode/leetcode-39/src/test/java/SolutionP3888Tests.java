import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3888Tests {
    private final SolutionP3888 solutionP3888 = new SolutionP3888();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[3,3,5],[3,3,5]]");
        int k = 2;
        long expected = 2;
        Assertions.assertEquals(expected, solutionP3888.minOperations(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,2],[2,3]]");
        int k = 1;
        long expected = 4;
        Assertions.assertEquals(expected, solutionP3888.minOperations(grid, k));
    }
}
