import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR191Tests {
    private final SolutionLCR191 solutionLCR191 = new SolutionLCR191();

    @Test
    public void example1() {
        int[] a = {1, 2, 3, 4, 5};
        int[] expected = {120, 60, 40, 30, 24};
        Assertions.assertArrayEquals(expected, solutionLCR191.statisticalResult(a));
    }
}
