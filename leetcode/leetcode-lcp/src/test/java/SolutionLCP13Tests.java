import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP13Tests {
    private final SolutionLCP13 solutionLCP13 = new SolutionLCP13();

    @Test
    public void example1() {
        String[] maze = {"S#O", "M..", "M.T"};
        int expected = 16;
        Assertions.assertEquals(expected, solutionLCP13.minimalSteps(maze));
    }

    @Test
    public void example2() {
        String[] maze = {"S#O", "M.#", "M.T"};
        int expected = -1;
        Assertions.assertEquals(expected, solutionLCP13.minimalSteps(maze));
    }

    @Test
    public void example3() {
        String[] maze = {"S#O", "M.T", "M.."};
        int expected = 17;
        Assertions.assertEquals(expected, solutionLCP13.minimalSteps(maze));
    }
}
