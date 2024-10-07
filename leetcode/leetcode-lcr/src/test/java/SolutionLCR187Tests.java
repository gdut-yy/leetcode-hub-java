import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR187Tests {
    private final SolutionLCR187 solutionLCR187 = new SolutionLCR187();

    @Test
    public void example1() {
        int n = 5;
        int m = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCR187.iceBreakingGame(n, m));
    }

    @Test
    public void example2() {
        int n = 10;
        int m = 17;
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCR187.iceBreakingGame(n, m));
    }
}
