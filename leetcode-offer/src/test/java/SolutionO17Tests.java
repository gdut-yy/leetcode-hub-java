import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO17Tests {
    private final SolutionO17 solutionO17 = new SolutionO17();

    @Test
    public void example1() {
        int n = 1;
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertArrayEquals(expected, solutionO17.printNumbers(n));
    }
}
