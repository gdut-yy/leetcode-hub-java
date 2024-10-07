import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR190Tests {
    private final SolutionLCR190 solutionLCR190 = new SolutionLCR190();

    @Test
    public void example1() {
        int a = 1;
        int b = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCR190.encryptionCalculate(a, b));
        Assertions.assertEquals(expected, solutionLCR190.encryptionCalculate2(a, b));
    }
}
