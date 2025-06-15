import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3572Tests {
    private final Solution3572 solution3572 = new Solution3572();

    @Test
    public void example1() {
        int[] x = {1, 2, 1, 3, 2};
        int[] y = {5, 3, 4, 6, 2};
        int expected = 14;
        Assertions.assertEquals(expected, solution3572.maxSumDistinctTriplet(x, y));
    }

    @Test
    public void example2() {
        int[] x = {1, 2, 1, 2};
        int[] y = {4, 5, 6, 7};
        int expected = -1;
        Assertions.assertEquals(expected, solution3572.maxSumDistinctTriplet(x, y));
    }
}