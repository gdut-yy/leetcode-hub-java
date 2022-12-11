import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP23Tests {
    private final SolutionLCP23 solutionLCP23 = new SolutionLCP23();

    @Test
    public void example1() {
        int[] target = {2, 4, 3, 1, 5};
        Assertions.assertTrue(solutionLCP23.isMagic(target));
    }

    @Test
    public void example2() {
        int[] target = {5, 4, 3, 2, 1};
        Assertions.assertFalse(solutionLCP23.isMagic(target));
    }
}
