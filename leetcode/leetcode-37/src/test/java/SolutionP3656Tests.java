import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3656Tests {
    private final SolutionP3656 solutionP3656 = new SolutionP3656();

    @Test
    public void example1() {
        int[] degrees = {3, 1, 2, 2};
        Assertions.assertTrue(solutionP3656.simpleGraphExists(degrees));
    }

    @Test
    public void example2() {
        int[] degrees = {1, 3, 3, 1};
        Assertions.assertFalse(solutionP3656.simpleGraphExists(degrees));
    }
}