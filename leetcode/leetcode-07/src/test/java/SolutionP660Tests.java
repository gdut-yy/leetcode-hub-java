import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP660Tests {
    private final SolutionP660 solutionP660 = new SolutionP660();

    @Test
    public void example1() {
        int n = 9;
        int expected = 10;
        Assertions.assertEquals(expected, solutionP660.newInteger(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 11;
        Assertions.assertEquals(expected, solutionP660.newInteger(n));
    }
}
