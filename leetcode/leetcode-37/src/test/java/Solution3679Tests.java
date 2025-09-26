import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3679Tests {
    private final Solution3679 solution3679 = new Solution3679();

    @Test
    public void example1() {
        int[] arrivals = {1, 2, 1, 3, 1};
        int w = 4;
        int m = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution3679.minArrivalsToDiscard(arrivals, w, m));
    }

    @Test
    public void example2() {
        int[] arrivals = {1, 2, 3, 3, 3, 4};
        int w = 3;
        int m = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution3679.minArrivalsToDiscard(arrivals, w, m));
    }
}