import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP49Tests {
    private final SolutionLCP49 solutionLCP49 = new SolutionLCP49();

    @Test
    public void example1() {
        long[] challenge = {5, 4, 6, 2, 7};
        long expected = 4;
        Assertions.assertEquals(expected, solutionLCP49.ringGame(challenge));
    }

    @Test
    public void example2() {
        long[] challenge = {12, 7, 11, 3, 9};
        long expected = 8;
        Assertions.assertEquals(expected, solutionLCP49.ringGame(challenge));
    }

    @Test
    public void example3() {
        long[] challenge = {1, 1, 1};
        long expected = 1;
        Assertions.assertEquals(expected, solutionLCP49.ringGame(challenge));
    }
}
