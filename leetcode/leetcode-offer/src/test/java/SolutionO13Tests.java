import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO13Tests {
    private final SolutionO13 solutionO13 = new SolutionO13();

    @Test
    public void example1() {
        int m = 2;
        int n = 3;
        int k = 1;
        int expected = 3;
        Assertions.assertEquals(expected, solutionO13.movingCount(m, n, k));
    }

    @Test
    public void example2() {
        int m = 3;
        int n = 1;
        int k = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solutionO13.movingCount(m, n, k));
    }
}
