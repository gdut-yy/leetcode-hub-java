import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO16Tests {
    private final SolutionO16 solutionO16 = new SolutionO16();

    @Test
    public void example1() {
        double x = 2.00000;
        int n = 10;
        double expected = 1024.00000;
        Assertions.assertEquals(expected, solutionO16.myPow(x, n), 1e-6);
    }

    @Test
    public void example2() {
        double x = 2.10000;
        int n = 3;
        double expected = 9.26100;
        Assertions.assertEquals(expected, solutionO16.myPow(x, n), 1e-6);
    }

    @Test
    public void example3() {
        double x = 2.00000;
        int n = -2;
        double expected = 0.25000;
        Assertions.assertEquals(expected, solutionO16.myPow(x, n), 1e-6);
    }
}
