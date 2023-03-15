import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO64Tests {
    private final SolutionO64 solutionO64 = new SolutionO64();

    @Test
    public void example1() {
        int n = 3;
        int expected = 6;
        Assertions.assertEquals(expected, solutionO64.sumNums(n));
    }

    @Test
    public void example2() {
        int n = 9;
        int expected = 45;
        Assertions.assertEquals(expected, solutionO64.sumNums(n));
    }
}
