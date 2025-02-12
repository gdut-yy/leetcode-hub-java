import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3429Tests {
    private final Solution3429 solution3429 = new Solution3429();

    @Test
    public void example1() {
        int n = 4;
        int[][] cost = UtUtils.stringToInts2("[[3,5,7],[6,2,9],[4,8,1],[7,3,5]]");
        long expected = 9;
        Assertions.assertEquals(expected, solution3429.minCost(n, cost));
    }

    @Test
    public void example2() {
        int n = 6;
        int[][] cost = UtUtils.stringToInts2("[[2,4,6],[5,3,8],[7,1,9],[4,6,2],[3,5,7],[8,2,4]]");
        long expected = 18;
        Assertions.assertEquals(expected, solution3429.minCost(n, cost));
    }
}