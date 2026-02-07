import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3662Tests {
    private final SolutionP3662 solutionP3662 = new SolutionP3662();

    @Test
    public void example1() {
        String s = "aadbbcccca";
        int k = 3;
        String expected = "dbb";
        Assertions.assertEquals(expected, solutionP3662.filterCharacters(s, k));
    }

    @Test
    public void example2() {
        String s = "xyz";
        int k = 2;
        String expected = "xyz";
        Assertions.assertEquals(expected, solutionP3662.filterCharacters(s, k));
    }
}