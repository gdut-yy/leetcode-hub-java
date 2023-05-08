import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP80Tests {
    private final SolutionLCP80 solutionLCP80 = new SolutionLCP80();

    @Test
    public void example1() {
        int[] parents = {-1, 0, 0, 2};
        String expected = "00110";
        Assertions.assertEquals(expected, solutionLCP80.evolutionaryRecord(parents));
    }

    @Test
    public void example2() {
        int[] parents = {-1, 0, 0, 1, 2, 2};
        String expected = "00101100";
        Assertions.assertEquals(expected, solutionLCP80.evolutionaryRecord(parents));
    }
}