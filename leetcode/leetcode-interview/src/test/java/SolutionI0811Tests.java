import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionI0811Tests {
    private final SolutionI0811 solutionI0811 = new SolutionI0811();

    @Test
    public void example1() {
        int n = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solutionI0811.waysToChange(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 4;
        Assertions.assertEquals(expected, solutionI0811.waysToChange(n));
    }
}
