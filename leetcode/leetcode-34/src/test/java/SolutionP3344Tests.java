import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3344Tests {
    private final SolutionP3344 solutionP3344 = new SolutionP3344();

    @Test
    public void example1() {
        long s = 10;
        int expected = 2;
        Assertions.assertEquals(expected, solutionP3344.maxSizedArray(s));
    }

    @Test
    public void example2() {
        long s = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solutionP3344.maxSizedArray(s));
    }
}