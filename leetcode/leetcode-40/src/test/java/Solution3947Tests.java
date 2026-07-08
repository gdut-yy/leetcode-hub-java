import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3947Tests {
    private final Solution3947 solution3947 = new Solution3947();

    @Test
    public void example1() {
        int[][] items = UtUtils.stringToInts2("[[1,6],[2,4],[3,5]]");
        int budget = 19;
        int expected = 5;
        Assertions.assertEquals(expected, solution3947.maximumSaleItems(items, budget));
    }

    @Test
    public void example2() {
        int[][] items = UtUtils.stringToInts2("[[2,8],[1,10],[6,6],[4,12],[5,20],[5,17]]");
        int budget = 35;
        int expected = 7;
        Assertions.assertEquals(expected, solution3947.maximumSaleItems(items, budget));
    }
}