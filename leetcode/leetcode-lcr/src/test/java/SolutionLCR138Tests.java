import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR138Tests {
    private final SolutionLCR138 solutionLCR138 = new SolutionLCR138();

    @Test
    public void example1() {
        String s = "0";
        Assertions.assertTrue(solutionLCR138.validNumber(s));
        Assertions.assertTrue(solutionLCR138.validNumber2(s));
    }

    @Test
    public void example2() {
        String s = "e";
        Assertions.assertFalse(solutionLCR138.validNumber(s));
        Assertions.assertFalse(solutionLCR138.validNumber2(s));
    }

    @Test
    public void example3() {
        String s = ".";
        Assertions.assertFalse(solutionLCR138.validNumber(s));
        Assertions.assertFalse(solutionLCR138.validNumber2(s));
    }

    @Test
    public void example4() {
        String s = "    .1  ";
        Assertions.assertTrue(solutionLCR138.validNumber(s));
        Assertions.assertTrue(solutionLCR138.validNumber2(s));
    }
}
