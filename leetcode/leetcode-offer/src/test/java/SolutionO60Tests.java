import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO60Tests {
    private final SolutionO60 solutionO60 = new SolutionO60();

    @Test
    public void example1() {
        int n = 1;
        double[] expected = {0.16667, 0.16667, 0.16667, 0.16667, 0.16667, 0.16667};
        Assertions.assertArrayEquals(expected, solutionO60.dicesProbability(n), 1e-5);
    }

    @Test
    public void example2() {
        int n = 2;
        double[] expected = {0.02778, 0.05556, 0.08333, 0.11111, 0.13889, 0.16667, 0.13889, 0.11111, 0.08333, 0.05556, 0.02778};
        Assertions.assertArrayEquals(expected, solutionO60.dicesProbability(n), 1e-5);
    }
}
