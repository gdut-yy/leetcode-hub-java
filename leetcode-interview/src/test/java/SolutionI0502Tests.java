import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0502Tests {
    private final SolutionI0502 solutionI0502 = new SolutionI0502();

    @Test
    public void example1() {
        double num = 0.625;
        String expected = "0.101";
        Assertions.assertEquals(expected, solutionI0502.printBin(num));
    }

    @Test
    public void example2() {
        double num = 0.1;
        String expected = "ERROR";
        Assertions.assertEquals(expected, solutionI0502.printBin(num));
    }
}