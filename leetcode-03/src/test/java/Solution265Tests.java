import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution265Tests {
    private final Solution265 solution265 = new Solution265();

    @Test
    public void example1() {
        int[][] costs = UtUtils.stringToInts2("[[1,5,3],[2,9,4]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution265.minCostII(costs));
    }

    @Test
    public void example2() {
        int[][] costs = UtUtils.stringToInts2("[[1,3],[2,4]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution265.minCostII(costs));
    }
}
