import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI1706Tests {
    private final SolutionI1706 solutionI1706 = new SolutionI1706();

    @Test
    public void example1() {
        int n = 25;
        int expected = 9;
        Assertions.assertEquals(expected, solutionI1706.numberOf2sInRange(n));
    }
}