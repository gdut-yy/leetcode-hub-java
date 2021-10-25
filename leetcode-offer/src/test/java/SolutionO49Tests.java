import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO49Tests {
    private final SolutionO49 solutionO49 = new SolutionO49();

    @Test
    public void example1() {
        int n = 10;
        int expected = 12;
        Assertions.assertEquals(expected, solutionO49.nthUglyNumber(n));
    }
}
