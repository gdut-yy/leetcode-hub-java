import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR169Tests {
    private final SolutionLCR169 solutionLCR169 = new SolutionLCR169();

    @Test
    public void example1() {
        String s = "abaccdeff";
        char expected = 'b';
        Assertions.assertEquals(expected, solutionLCR169.dismantlingAction(s));
    }

    @Test
    public void example2() {
        String s = "";
        char expected = ' ';
        Assertions.assertEquals(expected, solutionLCR169.dismantlingAction(s));
    }
}
