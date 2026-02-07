import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3773Tests {
    private final SolutionP3773 solutionP3773 = new SolutionP3773();

    @Test
    public void example1() {
        String S = "hello";
        int expected = 3;
        Assertions.assertEquals(expected, solutionP3773.maxSameLengthRuns(S));
    }

    @Test
    public void example2() {
        String S = "aaabaaa";
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3773.maxSameLengthRuns(S));
    }
}