import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP18Tests {
    private final SolutionLCP18 solutionLCP18 = new SolutionLCP18();

    @Test
    public void example1() {
        int[] staple = {10, 20, 5};
        int[] drinks = {5, 5, 2};
        int x = 15;
        int expected = 6;
        Assertions.assertEquals(expected, solutionLCP18.breakfastNumber(staple, drinks, x));
    }

    @Test
    public void example2() {
        int[] staple = {2, 1, 1};
        int[] drinks = {8, 9, 5, 1};
        int x = 9;
        int expected = 8;
        Assertions.assertEquals(expected, solutionLCP18.breakfastNumber(staple, drinks, x));
    }
}
