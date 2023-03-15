import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO44Tests {
    private final SolutionO44 solutionO44 = new SolutionO44();

    @Test
    public void example1() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solutionO44.findNthDigit(n));
    }

    @Test
    public void example2() {
        int n = 11;
        int expected = 0;
        Assertions.assertEquals(expected, solutionO44.findNthDigit(n));
    }
}
