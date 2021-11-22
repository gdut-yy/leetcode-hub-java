import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP1Tests {
    private final SolutionLCP1 solutionLCP1 = new SolutionLCP1();

    @Test
    public void example1() {
        int[] guess = {1, 2, 3};
        int[] answer = {1, 2, 3};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP1.game(guess, answer));
    }

    @Test
    public void example2() {
        int[] guess = {2, 2, 3};
        int[] answer = {3, 2, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solutionLCP1.game(guess, answer));
    }
}
