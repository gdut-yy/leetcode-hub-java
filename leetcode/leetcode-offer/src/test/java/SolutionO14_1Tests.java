import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO14_1Tests {
    private final SolutionO14_1 solutionO14_1 = new SolutionO14_1();

    @Test
    public void example1() {
        int n = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solutionO14_1.cuttingRope(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 36;
        Assertions.assertEquals(expected, solutionO14_1.cuttingRope(n));
    }
}
