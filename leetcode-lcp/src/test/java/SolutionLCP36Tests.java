import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP36Tests {
    private final SolutionLCP36 solutionLCP36 = new SolutionLCP36();

    @Test
    public void example1() {
        int[] tiles = {2, 2, 2, 3, 4};
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP36.maxGroupNumber(tiles));
    }

    @Test
    public void example2() {
        int[] tiles = {2, 2, 2, 3, 4, 1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP36.maxGroupNumber(tiles));
    }
}
