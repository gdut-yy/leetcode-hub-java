import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR165Tests {
    private final SolutionLCR165 solutionLCR165 = new SolutionLCR165();

    @Test
    public void example1() {
        int num = 12258;
        int expected = 5;
        Assertions.assertEquals(expected, solutionLCR165.crackNumber(num));
    }
}
