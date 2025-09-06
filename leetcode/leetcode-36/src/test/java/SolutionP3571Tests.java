import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3571Tests {
    private final SolutionP3571 solutionP3571 = new SolutionP3571();

    @Test
    public void example1() {
        String s1 = "aba";
        String s2 = "bab";
        String expected = "abab";
        Assertions.assertEquals(expected, solutionP3571.shortestSuperstring(s1, s2));
    }

    @Test
    public void example2() {
        String s1 = "aa";
        String s2 = "aaa";
        String expected = "aaa";
        Assertions.assertEquals(expected, solutionP3571.shortestSuperstring(s1, s2));
    }
}