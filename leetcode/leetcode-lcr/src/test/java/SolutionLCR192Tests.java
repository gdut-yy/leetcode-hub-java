import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR192Tests {
    private final SolutionLCR192 solutionLCR192 = new SolutionLCR192();

    @Test
    public void example1() {
        String s = "42";
        int expected = 42;
        Assertions.assertEquals(expected, solutionLCR192.myAtoi(s));
    }

    @Test
    public void example2() {
        String s = "   -42";
        int expected = -42;
        Assertions.assertEquals(expected, solutionLCR192.myAtoi(s));
    }

    @Test
    public void example3() {
        String s = "4193 with words";
        int expected = 4193;
        Assertions.assertEquals(expected, solutionLCR192.myAtoi(s));
    }

    @Test
    public void example4() {
        String s = "words and 987";
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCR192.myAtoi(s));
    }

    @Test
    public void example5() {
        String s = "-91283472332";
        int expected = -2147483648;
        Assertions.assertEquals(expected, solutionLCR192.myAtoi(s));
    }
}
