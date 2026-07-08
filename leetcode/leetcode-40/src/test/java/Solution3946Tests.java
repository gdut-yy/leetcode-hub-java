import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3946Tests {
    private final Solution3946 solution3946 = new Solution3946();

    @Test
    public void example1() {
        int[][] items = UtUtils.stringToInts2("[[6,2],[2,6],[3,4]]");
        int budget = 9;
        int expected = 4;
        Assertions.assertEquals(expected, solution3946.maximumSaleItems(items, budget));
    }

    @Test
    public void example2() {
        int[][] items = UtUtils.stringToInts2("[[2,4],[3,2],[4,1],[6,4],[12,4]]");
        int budget = 8;
        int expected = 10;
        Assertions.assertEquals(expected, solution3946.maximumSaleItems(items, budget));
    }
}