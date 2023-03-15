import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO58_1Tests {
    private final SolutionO58_1 solutionO58_1 = new SolutionO58_1();

    @Test
    public void example1() {
        String s = "the sky is blue";
        String expected = "blue is sky the";
        Assertions.assertEquals(expected, solutionO58_1.reverseWords(s));
    }

    @Test
    public void example2() {
        String s = "  hello world!  ";
        String expected = "world! hello";
        Assertions.assertEquals(expected, solutionO58_1.reverseWords(s));
    }

    @Test
    public void example3() {
        String s = "a good   example";
        String expected = "example good a";
        Assertions.assertEquals(expected, solutionO58_1.reverseWords(s));
    }
}
