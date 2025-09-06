import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3610Tests {
    private final SolutionP3610 solutionP3610 = new SolutionP3610();

    @Test
    public void example1() {
        int n = 10;
        int m = 2;
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3610.minNumberOfPrimes(n, m));
    }

    @Test
    public void example2() {
        int n = 15;
        int m = 5;
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3610.minNumberOfPrimes(n, m));
    }

    @Test
    public void example3() {
        int n = 7;
        int m = 6;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3610.minNumberOfPrimes(n, m));
    }
}