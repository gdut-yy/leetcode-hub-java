import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP53Tests {
    private final SolutionLCP53 solutionLCP53 = new SolutionLCP53();

    @Test
    public void example1() {
        int[] time = {1, 2, 1};
        int[] position = {6, 3, 3};
        int expected = 5;
        Assertions.assertEquals(expected, solutionLCP53.defendSpaceCity(time, position));
    }

    @Test
    public void example2() {
        int[] time = {1, 1, 1, 2, 2, 3, 5};
        int[] position = {1, 2, 3, 1, 2, 1, 3};
        int expected = 9;
        Assertions.assertEquals(expected, solutionLCP53.defendSpaceCity(time, position));
    }
}
