import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3385Tests {
    private final SolutionP3385 solutionP3385 = new SolutionP3385();

    @Test
    public void example1() {
        int[] strength = {3, 4, 1};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3385.findMinimumTime(strength));
    }

    @Test
    public void example2() {
        int[] strength = {2, 5, 4};
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3385.findMinimumTime(strength));
    }
}