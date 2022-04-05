import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution256Tests {
    private final Solution256 solution256 = new Solution256();

    @Test
    public void example1() {
        int[][] costs = UtUtils.stringToInts2("[[17,2,17],[16,16,5],[14,3,19]]");
        int expected = 10;
        Assertions.assertEquals(expected, solution256.minCost(costs));
    }

    @Test
    public void example2() {
        int[][] costs = UtUtils.stringToInts2("[[7,6,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution256.minCost(costs));
    }
}
