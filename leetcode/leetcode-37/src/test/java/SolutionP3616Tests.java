import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3616Tests {
    private final SolutionP3616 solutionP3616 = new SolutionP3616();

    @Test
    public void example1() {
        int[] ranks = {4, 1, 2};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3616.totalReplacements(ranks));
    }

    @Test
    public void example2() {
        int[] ranks = {2, 2, 3};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3616.totalReplacements(ranks));
    }
}