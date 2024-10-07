import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR127Tests {
    private final SolutionLCR127 solutionLCR127 = new SolutionLCR127();

    @Test
    public void example1() {
        int n = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCR127.trainWays(n));
    }

    @Test
    public void example2() {
        int n = 7;
        int expected = 21;
        Assertions.assertEquals(expected, solutionLCR127.trainWays(n));
    }

    @Test
    public void example3() {
        int n = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCR127.trainWays(n));
    }
}
