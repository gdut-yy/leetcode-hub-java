import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3491Tests {
    private final SolutionP3491 solutionP3491 = new SolutionP3491();

    @Test
    public void example1() {
        String[] numbers = {"1", "2", "4", "3"};
        Assertions.assertTrue(solutionP3491.phonePrefix(numbers));
    }

    @Test
    public void example2() {
        String[] numbers = {"001", "007", "15", "00153"};
        Assertions.assertFalse(solutionP3491.phonePrefix(numbers));
    }
}