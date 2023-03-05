import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6313Tests {
    private final Solution6313 solution6313 = new Solution6313();

    @Test
    public void example1() {
        int[][] ranges = UtUtils.stringToInts2("[[6,10],[5,15]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution6313.countWays(ranges));
    }

    @Test
    public void example2() {
        int[][] ranges = UtUtils.stringToInts2("[[1,3],[10,20],[2,5],[4,8]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution6313.countWays(ranges));
    }
}