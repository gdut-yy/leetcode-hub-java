import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3581Tests {
    private final SolutionP3581 solutionP3581 = new SolutionP3581();

    @Test
    public void example1() {
        int n = 41;
        int expected = 5;
        Assertions.assertEquals(expected, solutionP3581.countOddLetters(n));
    }

    @Test
    public void example2() {
        int n = 20;
        int expected = 5;
        Assertions.assertEquals(expected, solutionP3581.countOddLetters(n));
    }
}