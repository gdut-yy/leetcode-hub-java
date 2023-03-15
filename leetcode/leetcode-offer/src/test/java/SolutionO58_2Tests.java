import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO58_2Tests {
    private final SolutionO58_2 solutionO58_2 = new SolutionO58_2();

    @Test
    public void example1() {
        String s = "abcdefg";
        int n = 2;
        String expected = "cdefgab";
        Assertions.assertEquals(expected, solutionO58_2.reverseLeftWords(s, n));
    }

    @Test
    public void example2() {
        String s = "lrloseumgh";
        int n = 6;
        String expected = "umghlrlose";
        Assertions.assertEquals(expected, solutionO58_2.reverseLeftWords(s, n));
    }
}
