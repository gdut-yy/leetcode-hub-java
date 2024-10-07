import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR148Tests {
    private final SolutionLCR148 solutionLCR148 = new SolutionLCR148();

    @Test
    public void example1() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        Assertions.assertTrue(solutionLCR148.validateBookSequences(pushed, popped));
    }

    @Test
    public void example2() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        Assertions.assertFalse(solutionLCR148.validateBookSequences(pushed, popped));
    }
}
