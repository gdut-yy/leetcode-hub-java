import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3540Tests {
    private final SolutionP3540 solutionP3540 = new SolutionP3540();

    @Test
    public void example1() {
        int[] forward = {1, 4, 4};
        int[] backward = {4, 1, 2};
        int[] queries = {1, 2, 0, 2};
        long expected = 12;
        Assertions.assertEquals(expected, solutionP3540.minTotalTime(forward, backward, queries));
    }

    @Test
    public void example2() {
        int[] forward = {1, 1, 1, 1};
        int[] backward = {2, 2, 2, 2};
        int[] queries = {1, 2, 3, 0};
        long expected = 4;
        Assertions.assertEquals(expected, solutionP3540.minTotalTime(forward, backward, queries));
    }
}