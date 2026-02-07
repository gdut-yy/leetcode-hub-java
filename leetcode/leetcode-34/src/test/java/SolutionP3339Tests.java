import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3339Tests {
    private final SolutionP3339 solutionP3339 = new SolutionP3339();

    @Test
    public void example1() {
        int n = 3;
        int m = 4;
        int k = 2;
        int expected = 8;
        Assertions.assertEquals(expected, solutionP3339.countOfArrays(n, m, k));
    }

    @Test
    public void example2() {
        int n = 5;
        int m = 1;
        int k = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3339.countOfArrays(n, m, k));
    }

    @Test
    public void example3() {
        int n = 7;
        int m = 7;
        int k = 5;
        int expected = 5832;
        Assertions.assertEquals(expected, solutionP3339.countOfArrays(n, m, k));
    }
}