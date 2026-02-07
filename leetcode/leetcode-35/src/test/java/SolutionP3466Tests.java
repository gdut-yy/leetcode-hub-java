import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3466Tests {
    private final SolutionP3466 solutionP3466 = new SolutionP3466();

    @Test
    public void example1() {
        int[] lane1 = {1, -2, -10, 3};
        int[] lane2 = {-5, 10, 0, 1};
        long expected = 14;
        Assertions.assertEquals(expected, solutionP3466.maxCoins(lane1, lane2));
    }

    @Test
    public void example2() {
        int[] lane1 = {1, -1, -1, -1};
        int[] lane2 = {0, 3, 4, -5};
        long expected = 8;
        Assertions.assertEquals(expected, solutionP3466.maxCoins(lane1, lane2));
    }

    @Test
    public void example3() {
        int[] lane1 = {-5, -4, -3};
        int[] lane2 = {-1, 2, 3};
        long expected = 5;
        Assertions.assertEquals(expected, solutionP3466.maxCoins(lane1, lane2));
    }

    @Test
    public void example4() {
        int[] lane1 = {-3, -3, -3};
        int[] lane2 = {9, -2, 4};
        long expected = 11;
        Assertions.assertEquals(expected, solutionP3466.maxCoins(lane1, lane2));
    }

    @Test
    public void example5() {
        int[] lane1 = {-10};
        int[] lane2 = {-2};
        long expected = -2;
        Assertions.assertEquals(expected, solutionP3466.maxCoins(lane1, lane2));
    }
}