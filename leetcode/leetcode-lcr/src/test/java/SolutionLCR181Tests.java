import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCR181Tests {
    private final SolutionLCR181 solutionLCR181 = new SolutionLCR181();

    @Test
    public void example1() {
        String s = "the sky is blue";
        String expected = "blue is sky the";
        Assertions.assertEquals(expected, solutionLCR181.reverseMessage(s));
    }

    @Test
    public void example2() {
        String s = "  hello world!  ";
        String expected = "world! hello";
        Assertions.assertEquals(expected, solutionLCR181.reverseMessage(s));
    }

    @Test
    public void example3() {
        String s = "a good   example";
        String expected = "example good a";
        Assertions.assertEquals(expected, solutionLCR181.reverseMessage(s));
    }
}
