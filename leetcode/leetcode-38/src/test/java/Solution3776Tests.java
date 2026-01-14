import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3776Tests {
    private final Solution3776 solution37762 = new Solution3776();

    @Test
    public void example1() {
        int[] balance = {5, 1, -4};
        long expected = 4;
        Assertions.assertEquals(expected, solution37762.minMoves(balance));
    }

    @Test
    public void example2() {
        int[] balance = {1, 2, -5, 2};
        long expected = 6;
        Assertions.assertEquals(expected, solution37762.minMoves(balance));
    }

    @Test
    public void example3() {
        int[] balance = {-3, 2};
        long expected = -1;
        Assertions.assertEquals(expected, solution37762.minMoves(balance));
    }
}