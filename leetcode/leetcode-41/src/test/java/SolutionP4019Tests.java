import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP4019Tests {
    private final SolutionP4019 solutionP4019 = new SolutionP4019();

    @Test
    public void example1() {
        String s = "abca";
        int k = 3;
        String expected = "abc";
        Assertions.assertEquals(expected, solutionP4019.mergeCharacters(s, k));
    }

    @Test
    public void example2() {
        String s = "aabca";
        int k = 2;
        String expected = "abca";
        Assertions.assertEquals(expected, solutionP4019.mergeCharacters(s, k));
    }

    @Test
    public void example3() {
        String s = "yybyzybz";
        int k = 2;
        String expected = "ybzybz";
        Assertions.assertEquals(expected, solutionP4019.mergeCharacters(s, k));
    }
}
