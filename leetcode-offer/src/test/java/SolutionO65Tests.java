import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO65Tests {
    private final SolutionO65 solutionO65 = new SolutionO65();

    @Test
    public void example1() {
        int a = 1;
        int b = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solutionO65.add(a, b));
        Assertions.assertEquals(expected, solutionO65.add2(a, b));
    }
}
