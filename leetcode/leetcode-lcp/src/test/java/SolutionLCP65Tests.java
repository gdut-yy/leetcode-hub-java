import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP65Tests {
    private final SolutionLCP65 solutionLCP65 = new SolutionLCP65();

    @Test
    public void example1() {
        int[] operate = {5, 3, 7};
        int expected = 8;
        Assertions.assertEquals(expected, solutionLCP65.unSuitability(operate));
    }

    @Test
    public void example2() {
        int[] operate = {20, 10};
        int expected = 20;
        Assertions.assertEquals(expected, solutionLCP65.unSuitability(operate));
    }
}
