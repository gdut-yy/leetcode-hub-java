import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO62Tests {
    private final SolutionO62 solutionO62 = new SolutionO62();

    @Test
    public void example1() {
        int n = 5;
        int m = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solutionO62.lastRemaining(n, m));
    }

    @Test
    public void example2() {
        int n = 10;
        int m = 17;
        int expected = 2;
        Assertions.assertEquals(expected, solutionO62.lastRemaining(n, m));
    }
}
