import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0801Tests {
    private final SolutionI0801 solutionI0801 = new SolutionI0801();

    @Test
    public void example1() {
        int n = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solutionI0801.waysToStep(n));
    }

    @Test
    public void example2() {
        int n = 5;
        int expected = 13;
        Assertions.assertEquals(expected, solutionI0801.waysToStep(n));
    }
}
