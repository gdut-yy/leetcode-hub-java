import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR135Tests {
    private final SolutionLCR135 solutionLCR135 = new SolutionLCR135();

    @Test
    public void example1() {
        int n = 1;
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertArrayEquals(expected, solutionLCR135.countNumbers(n));
    }
}
