import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3647Tests {
    private final SolutionP3647 solutionP3647 = new SolutionP3647();

    @Test
    public void example1() {
        int[] weights = {1, 4, 3, 2};
        int w1 = 5;
        int w2 = 4;
        int expected = 9;
        Assertions.assertEquals(expected, solutionP3647.maxWeight(weights, w1, w2));
    }

    @Test
    public void example2() {
        int[] weights = {3, 6, 4, 8};
        int w1 = 9;
        int w2 = 7;
        int expected = 15;
        Assertions.assertEquals(expected, solutionP3647.maxWeight(weights, w1, w2));
    }

    @Test
    public void example3() {
        int[] weights = {5, 7};
        int w1 = 2;
        int w2 = 3;
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3647.maxWeight(weights, w1, w2));
    }
}