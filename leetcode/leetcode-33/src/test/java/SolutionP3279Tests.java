import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3279Tests {
    private final SolutionP3279 solutionP3279 = new SolutionP3279();

    @Test
    public void example1() {
        int height = 5;
        int[] positions = {2, 5};
        String directions = "UD";
        long expected = 7;
        Assertions.assertEquals(expected, solutionP3279.maxArea(height, positions, directions));
    }

    @Test
    public void example2() {
        int height = 6;
        int[] positions = {0, 0, 6, 3};
        String directions = "UUDU";
        long expected = 15;
        Assertions.assertEquals(expected, solutionP3279.maxArea(height, positions, directions));
    }
}