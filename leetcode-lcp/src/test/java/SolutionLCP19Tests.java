import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP19Tests {
    private final SolutionLCP19 solutionLCP19 = new SolutionLCP19();

    @Test
    public void example1() {
        String leaves = "rrryyyrryyyrr";
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP19.minimumOperations(leaves));
    }

    @Test
    public void example2() {
        String leaves = "ryr";
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP19.minimumOperations(leaves));
    }
}
