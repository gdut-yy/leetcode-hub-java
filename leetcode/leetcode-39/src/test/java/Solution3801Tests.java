import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3801Tests {
    private final Solution3801 solution3801 = new Solution3801();

    @Test
    public void example1() {
        int[][] lists = UtUtils.stringToInts2("[[1,3,5],[2,4],[6,7,8]]");
        long expected = 18;
        Assertions.assertEquals(expected, solution3801.minMergeCost(lists));
    }

    @Test
    public void example2() {
        int[][] lists = UtUtils.stringToInts2("[[1,1,5],[1,4,7,8]]");
        long expected = 10;
        Assertions.assertEquals(expected, solution3801.minMergeCost(lists));
    }

    @Test
    public void example3() {
        int[][] lists = UtUtils.stringToInts2("[[1],[3]]");
        long expected = 4;
        Assertions.assertEquals(expected, solution3801.minMergeCost(lists));
    }

    @Test
    public void example4() {
        int[][] lists = UtUtils.stringToInts2("[[1],[1]]");
        long expected = 2;
        Assertions.assertEquals(expected, solution3801.minMergeCost(lists));
    }
}