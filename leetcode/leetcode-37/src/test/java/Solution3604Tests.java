import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3604Tests {
    private final Solution3604 solution3604 = new Solution3604();

    @Test
    public void example1() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[0,1,0,1],[1,2,2,5]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution3604.minTime(n, edges));
    }

    @Test
    public void example2() {
        int n = 4;
        int[][] edges = UtUtils.stringToInts2("[[0,1,0,3],[1,3,7,8],[0,2,1,5],[2,3,4,7]]");
        int expected = 5;
        Assertions.assertEquals(expected, solution3604.minTime(n, edges));
    }

    @Test
    public void example3() {
        int n = 3;
        int[][] edges = UtUtils.stringToInts2("[[1,0,1,3],[1,2,3,5]]");
        int expected = -1;
        Assertions.assertEquals(expected, solution3604.minTime(n, edges));
    }
}