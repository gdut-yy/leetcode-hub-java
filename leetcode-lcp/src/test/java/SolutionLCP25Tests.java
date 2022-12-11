import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP25Tests {
    private final SolutionLCP25 solutionLCP25 = new SolutionLCP25();

    @Test
    public void example1() {
        int k = 1;
        int n = 1;
        int expected = 26;
        Assertions.assertEquals(expected, solutionLCP25.keyboard(k, n));
    }

    @Test
    public void example2() {
        int k = 1;
        int n = 2;
        int expected = 650;
        Assertions.assertEquals(expected, solutionLCP25.keyboard(k, n));
    }
}
