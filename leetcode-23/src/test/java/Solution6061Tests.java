import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6061Tests {
    private final Solution6061 solution6061 = new Solution6061();

    @Test
    public void example1() {
        int total = 20;
        int cost1 = 10;
        int cost2 = 5;
        long expected = 9;
        Assertions.assertEquals(expected, solution6061.waysToBuyPensPencils(total, cost1, cost2));
    }

    @Test
    public void example2() {
        int total = 5;
        int cost1 = 10;
        int cost2 = 10;
        long expected = 1;
        Assertions.assertEquals(expected, solution6061.waysToBuyPensPencils(total, cost1, cost2));
    }
}
