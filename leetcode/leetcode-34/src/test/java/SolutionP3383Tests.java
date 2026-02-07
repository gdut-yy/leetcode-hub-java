import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3383Tests {
    private final SolutionP3383 solutionP3383 = new SolutionP3383();

    @Test
    public void example1() {
        int n = 6;
        int[] crystals = {0};
        int[] flowFrom = {0, 1, 2, 3};
        int[] flowTo = {1, 2, 3, 0};
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3383.minRunesToAdd(n, crystals, flowFrom, flowTo));
    }

    @Test
    public void example2() {
        int n = 7;
        int[] crystals = {3, 5};
        int[] flowFrom = {0, 1, 2, 3, 5};
        int[] flowTo = {1, 2, 0, 4, 6};
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3383.minRunesToAdd(n, crystals, flowFrom, flowTo));
    }
}