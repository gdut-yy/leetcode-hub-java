import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR167Tests {
    private final SolutionLCR167 solutionLCR167 = new SolutionLCR167();

    @Test
    public void example1() {
        String s = "abcabcbb";
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCR167.dismantlingAction(s));
    }

    @Test
    public void example2() {
        String s = "bbbbb";
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCR167.dismantlingAction(s));
    }

    @Test
    public void example3() {
        String s = "pwwkew";
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCR167.dismantlingAction(s));
    }
}
