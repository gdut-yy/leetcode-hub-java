import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP43Tests {
    private final SolutionLCP43 solutionLCP43 = new SolutionLCP43();

    @Test
    public void example1() {
        String[] directions = {"W", "N", "ES", "W"};
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP43.trafficCommand(directions));
    }

    @Test
    public void example2() {
        String[] directions = {"NS", "WE", "SE", "EW"};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP43.trafficCommand(directions));
    }
}
