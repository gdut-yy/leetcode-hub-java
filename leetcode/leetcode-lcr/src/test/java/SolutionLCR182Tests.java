import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR182Tests {
    private final SolutionLCR182 solutionLCR182 = new SolutionLCR182();

    @Test
    public void example1() {
        String s = "abcdefg";
        int n = 2;
        String expected = "cdefgab";
        Assertions.assertEquals(expected, solutionLCR182.dynamicPassword(s, n));
        Assertions.assertEquals(expected, solutionLCR182.dynamicPassword2(s, n));
    }

    @Test
    public void example2() {
        String s = "lrloseumgh";
        int n = 6;
        String expected = "umghlrlose";
        Assertions.assertEquals(expected, solutionLCR182.dynamicPassword(s, n));
        Assertions.assertEquals(expected, solutionLCR182.dynamicPassword2(s, n));
    }
}
