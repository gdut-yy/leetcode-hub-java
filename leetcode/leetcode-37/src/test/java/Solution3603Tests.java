import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3603Tests {
    private final Solution3603 solution3603 = new Solution3603();

    @Test
    public void example1() {
        int m = 1;
        int n = 2;
        int[][] waitCost = UtUtils.stringToInts2("[[1,2]]");
        long expected = 3;
        Assertions.assertEquals(expected, solution3603.minCost(m, n, waitCost));
    }

    @Test
    public void example2() {
        int m = 2;
        int n = 2;
        int[][] waitCost = UtUtils.stringToInts2("[[3,5],[2,4]]");
        long expected = 9;
        Assertions.assertEquals(expected, solution3603.minCost(m, n, waitCost));
    }

    @Test
    public void example3() {
        int m = 2;
        int n = 3;
        int[][] waitCost = UtUtils.stringToInts2("[[6,1,4],[3,2,5]]");
        long expected = 16;
        Assertions.assertEquals(expected, solution3603.minCost(m, n, waitCost));
    }
}