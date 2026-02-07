import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3730Tests {
    private final SolutionP3730 solutionP3730 = new SolutionP3730();

    @Test
    public void example1() {
        int[] heights = {1, 7, 9};
        long expected = 181;
        Assertions.assertEquals(expected, solutionP3730.maxCaloriesBurnt(heights));
    }

    @Test
    public void example2() {
        int[] heights = {5, 2, 4};
        long expected = 38;
        Assertions.assertEquals(expected, solutionP3730.maxCaloriesBurnt(heights));
    }

    @Test
    public void example3() {
        int[] heights = {3, 3};
        long expected = 9;
        Assertions.assertEquals(expected, solutionP3730.maxCaloriesBurnt(heights));
    }
}