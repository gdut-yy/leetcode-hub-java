import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3608Tests {
    private final Solution3608 solution3608 = new Solution3608();

    @Test
    public void example1() {
        int n = 2;
        int[][] edges = UtUtils.stringToInts2("[[0,1,3]]");
        int k = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution3608.minTime(n, edges, k));
    }

    @Test
    public void example2() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,2],[1,2,4]]");
        int k = 3;
        int expected = 4;
        Assertions.assertEquals(expected, solution3608.minTime(n, edges, k));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,2,5]]");
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution3608.minTime(n, edges, k));
    }
}