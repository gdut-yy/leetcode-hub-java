import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3329Tests {
    private final SolutionP3329 solutionP3329 = new SolutionP3329();

    @Test
    public void example1() {
        String s = "abacb";
        int k = 2;
        long expected = 4;
        Assertions.assertEquals(expected, solutionP3329.numberOfSubstrings(s, k));
    }

    @Test
    public void example2() {
        String s = "abcde";
        int k = 1;
        long expected = 15;
        Assertions.assertEquals(expected, solutionP3329.numberOfSubstrings(s, k));
    }
}