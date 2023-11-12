import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI1610Tests {
    private final SolutionI1610 solutionI1610 = new SolutionI1610();

    @Test
    public void example1() {
        int[] birth = {1900, 1901, 1950};
        int[] death = {1948, 1951, 2000};
        int expected = 1901;
        Assertions.assertEquals(expected, solutionI1610.maxAliveYear(birth, death));
    }
}