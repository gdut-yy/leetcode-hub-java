import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0105Tests {
    private final SolutionI0105 solutionI0105 = new SolutionI0105();

    @Test
    public void example1() {
        String first = "pale";
        String second = "ple";
        Assertions.assertTrue(solutionI0105.oneEditAway(first, second));
    }

    @Test
    public void example2() {
        String first = "pales";
        String second = "pal";
        Assertions.assertFalse(solutionI0105.oneEditAway(first, second));
    }
}
