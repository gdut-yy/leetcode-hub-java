import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR162Tests {
    private final SolutionLCR162 solutionLCR162 = new SolutionLCR162();

    @Test
    public void example1() {
        int n = 12;
        int expected = 5;
        Assertions.assertEquals(expected, solutionLCR162.digitOneInNumber(n));
    }

    @Test
    public void example2() {
        int n = 13;
        int expected = 6;
        Assertions.assertEquals(expected, solutionLCR162.digitOneInNumber(n));
    }
}
