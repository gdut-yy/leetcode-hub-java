import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6310Tests {
    private final Solution6310 solution6310 = new Solution6310();

    @Test
    public void example1() {
        int target = 6;
        int[][] types = UtUtils.stringToInts2("[[6,1],[3,2],[2,3]]");
        int expected = 7;
        Assertions.assertEquals(expected, solution6310.waysToReachTarget(target, types));
    }

    @Test
    public void example2() {
        int target = 5;
        int[][] types = UtUtils.stringToInts2("[[50,1],[50,2],[50,5]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution6310.waysToReachTarget(target, types));
    }

    @Test
    public void example3() {
        int target = 18;
        int[][] types = UtUtils.stringToInts2("[[6,1],[3,2],[2,3]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution6310.waysToReachTarget(target, types));
    }
}