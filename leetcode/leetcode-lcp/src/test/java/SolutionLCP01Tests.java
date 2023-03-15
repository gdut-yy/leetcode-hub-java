import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP01Tests {
    private final SolutionLCP01 solutionLCP01 = new SolutionLCP01();

    @Test
    public void example1() {
        int[] guess = {1, 2, 3};
        int[] answer = {1, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP01.game(guess, answer));
    }

    @Test
    public void example2() {
        int[] guess = {2, 2, 3};
        int[] answer = {3, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP01.game(guess, answer));
    }
}
