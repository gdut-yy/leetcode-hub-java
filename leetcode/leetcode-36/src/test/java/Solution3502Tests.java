import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3502Tests {
    private final Solution3502 solution3502 = new Solution3502();

    @Test
    public void example1() {
        int[] cost = {5, 3, 4, 1, 3, 2};
        int[] expected = {5, 3, 3, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution3502.minCosts(cost));
    }

    @Test
    public void example2() {
        int[] cost = {1, 2, 4, 6, 7};
        int[] expected = {1, 1, 1, 1, 1};
        Assertions.assertArrayEquals(expected, solution3502.minCosts(cost));
    }
}