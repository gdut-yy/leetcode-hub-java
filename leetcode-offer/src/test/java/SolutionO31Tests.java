import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO31Tests {
    private final SolutionO31 solutionO31 = new SolutionO31();

    @Test
    public void example1() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        Assertions.assertTrue(solutionO31.validateStackSequences(pushed, popped));
    }

    @Test
    public void example2() {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        Assertions.assertFalse(solutionO31.validateStackSequences(pushed, popped));
    }
}
