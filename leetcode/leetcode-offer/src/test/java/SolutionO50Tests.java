import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO50Tests {
    private final SolutionO50 solutionO50 = new SolutionO50();

    @Test
    public void example1() {
        String s = "abaccdeff";
        char expected = 'b';
        Assertions.assertEquals(expected, solutionO50.firstUniqChar(s));
    }

    @Test
    public void example2() {
        String s = "";
        char expected = ' ';
        Assertions.assertEquals(expected, solutionO50.firstUniqChar(s));
    }
}
