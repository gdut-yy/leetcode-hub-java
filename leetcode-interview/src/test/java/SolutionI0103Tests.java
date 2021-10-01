import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0103Tests {
    private final SolutionI0103 solutionI0103 = new SolutionI0103();

    @Test
    public void example1() {
        String S = "Mr John Smith    ";
        int length = 13;
        String expected = "Mr%20John%20Smith";
        Assertions.assertEquals(expected, solutionI0103.replaceSpaces(S, length));
    }

    @Test
    public void example2() {
        String S = "               ";
        int length = 5;
        String expected = "%20%20%20%20%20";
        Assertions.assertEquals(expected, solutionI0103.replaceSpaces(S, length));
    }
}
