import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO20Tests {
    private final SolutionO20 solutionO20 = new SolutionO20();

    @Test
    public void example1() {
        String s = "0";
        Assertions.assertTrue(solutionO20.isNumber(s));
        Assertions.assertTrue(solutionO20.isNumber2(s));
    }

    @Test
    public void example2() {
        String s = "e";
        Assertions.assertFalse(solutionO20.isNumber(s));
        Assertions.assertFalse(solutionO20.isNumber2(s));
    }

    @Test
    public void example3() {
        String s = ".";
        Assertions.assertFalse(solutionO20.isNumber(s));
        Assertions.assertFalse(solutionO20.isNumber2(s));
    }

    @Test
    public void example4() {
        String s = "    .1  ";
        Assertions.assertTrue(solutionO20.isNumber(s));
        Assertions.assertTrue(solutionO20.isNumber2(s));
    }
}
