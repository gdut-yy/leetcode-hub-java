import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3382Tests {
    private final Solution3382 solution3382 = new Solution3382();

    @Test
    public void example1() {
        int[] xCoord = {1, 1, 3, 3};
        int[] yCoord = {1, 3, 1, 3};
        long expected = 4;
        Assertions.assertEquals(expected, solution3382.maxRectangleArea(xCoord, yCoord));
    }

    @Test
    public void example2() {
        int[] xCoord = {1, 1, 3, 3, 2};
        int[] yCoord = {1, 3, 1, 3, 2};
        long expected = -1;
        Assertions.assertEquals(expected, solution3382.maxRectangleArea(xCoord, yCoord));
    }

    @Test
    public void example3() {
        int[] xCoord = {1, 1, 3, 3, 1, 3};
        int[] yCoord = {1, 3, 1, 3, 2, 2};
        long expected = 2;
        Assertions.assertEquals(expected, solution3382.maxRectangleArea(xCoord, yCoord));
    }
}