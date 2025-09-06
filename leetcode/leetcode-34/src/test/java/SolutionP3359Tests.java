import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3359Tests {
    private final SolutionP3359 solutionP3359 = new SolutionP3359();

    @Test
    public void example1() {
        int[][] grid = UtUtils.stringToInts2("[[4,3,2,1],[8,7,6,1]]");
        int k = 3;
        long expected = 8;
        Assertions.assertEquals(expected, solutionP3359.countSubmatrices(grid, k));
    }

    @Test
    public void example2() {
        int[][] grid = UtUtils.stringToInts2("[[1,1,1],[1,1,1],[1,1,1]]");
        int k = 1;
        long expected = 36;
        Assertions.assertEquals(expected, solutionP3359.countSubmatrices(grid, k));
    }

    @Test
    public void example3() {
        int[][] grid = UtUtils.stringToInts2("[[1]]");
        int k = 1;
        long expected = 1;
        Assertions.assertEquals(expected, solutionP3359.countSubmatrices(grid, k));
    }
}