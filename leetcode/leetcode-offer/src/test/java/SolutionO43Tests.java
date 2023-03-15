import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO43Tests {
    private final SolutionO43 solutionO43 = new SolutionO43();

    @Test
    public void example1() {
        int n = 12;
        int expected = 5;
        Assertions.assertEquals(expected, solutionO43.countDigitOne(n));
    }

    @Test
    public void example2() {
        int n = 13;
        int expected = 6;
        Assertions.assertEquals(expected, solutionO43.countDigitOne(n));
    }
}
