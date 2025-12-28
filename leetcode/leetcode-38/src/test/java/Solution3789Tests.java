import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3789Tests {
    private final Solution3789 solution3789 = new Solution3789();

    @Test
    public void example1() {
        int cost1 = 3;
        int cost2 = 2;
        int costBoth = 1;
        int need1 = 3;
        int need2 = 2;
        long expected = 3;
        Assertions.assertEquals(expected, solution3789.minimumCost(cost1, cost2, costBoth, need1, need2));
    }

    @Test
    public void example2() {
        int cost1 = 5;
        int cost2 = 4;
        int costBoth = 15;
        int need1 = 2;
        int need2 = 3;
        long expected = 22;
        Assertions.assertEquals(expected, solution3789.minimumCost(cost1, cost2, costBoth, need1, need2));
    }

    @Test
    public void example3() {
        int cost1 = 5;
        int cost2 = 4;
        int costBoth = 15;
        int need1 = 0;
        int need2 = 0;
        long expected = 0;
        Assertions.assertEquals(expected, solution3789.minimumCost(cost1, cost2, costBoth, need1, need2));
    }
}