import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP4004Tests {
    private final SolutionP4004 solutionP4004 = new SolutionP4004();

    @Test
    public void example1() {
        int[] balance = {-1, 2, -1};
        long expected = 2;
        Assertions.assertEquals(expected, solutionP4004.minMoves(balance));
    }

    @Test
    public void example2() {
        int[] balance = {4, -1, -2};
        long expected = 3;
        Assertions.assertEquals(expected, solutionP4004.minMoves(balance));
    }

    @Test
    public void example3() {
        int[] balance = {-3, -3, 5};
        long expected = -1;
        Assertions.assertEquals(expected, solutionP4004.minMoves(balance));
    }
}
