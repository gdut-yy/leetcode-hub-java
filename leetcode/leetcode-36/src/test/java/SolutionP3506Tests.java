import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3506Tests {
    private final SolutionP3506 solutionP3506 = new SolutionP3506();

    @Test
    public void example1() {
        int[] timeReq = {10, 4, 5};
        int splitTime = 2;
        long expected = 12;
        Assertions.assertEquals(expected, solutionP3506.minEliminationTime(timeReq, splitTime));
    }

    @Test
    public void example2() {
        int[] timeReq = {10, 4};
        int splitTime = 5;
        long expected = 15;
        Assertions.assertEquals(expected, solutionP3506.minEliminationTime(timeReq, splitTime));
    }
}