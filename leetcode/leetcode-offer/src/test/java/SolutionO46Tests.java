import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO46Tests {
    private final SolutionO46 solutionO46 = new SolutionO46();

    @Test
    public void example1() {
        int num = 12258;
        int expected = 5;
        Assertions.assertEquals(expected, solutionO46.translateNum(num));
    }
}
