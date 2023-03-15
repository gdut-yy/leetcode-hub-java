import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution774Tests {
    private final Solution774 solution774 = new Solution774();

    @Test
    public void example1() {
        int[] stations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 9;
        double expected = 0.50000;
        Assertions.assertEquals(expected, solution774.minmaxGasDist(stations, k), 1e-6);
    }

    @Test
    public void example2() {
        int[] stations = {23, 24, 36, 39, 46, 56, 57, 65, 84, 98};
        int k = 1;
        double expected = 14.00000;
        Assertions.assertEquals(expected, solution774.minmaxGasDist(stations, k), 1e-6);
    }
}
