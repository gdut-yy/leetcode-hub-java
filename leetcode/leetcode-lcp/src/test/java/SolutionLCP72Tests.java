import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP72Tests {
    private final SolutionLCP72 solutionLCP72 = new SolutionLCP72();

    @Test
    public void example1() {
        int[] supplies = {7, 3, 6, 1, 8};
        int[] expected = {10, 15};
        Assertions.assertArrayEquals(expected, solutionLCP72.supplyWagon(supplies));
    }

    @Test
    public void example2() {
        int[] supplies = {1, 3, 1, 5};
        int[] expected = {5, 5};
        Assertions.assertArrayEquals(expected, solutionLCP72.supplyWagon(supplies));
    }
}