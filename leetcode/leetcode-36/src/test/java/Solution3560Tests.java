import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3560Tests {
    private final Solution3560 solution3560 = new Solution3560();

    @Test
    public void example1() {
        int n = 6;
        int m = 5;
        int k = 5;
        long expected = 5;
        Assertions.assertEquals(expected, solution3560.minCuttingCost(n, m, k));
    }

    @Test
    public void example2() {
        int n = 4;
        int m = 4;
        int k = 6;
        long expected = 0;
        Assertions.assertEquals(expected, solution3560.minCuttingCost(n, m, k));
    }
}