import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6318Tests {
    private final Solution6318 solution6318 = new Solution6318();

    @Test
    public void example1() {
        int[][] tasks = UtUtils.stringToInts2("[[2,3,1],[4,5,1],[1,5,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution6318.findMinimumTime(tasks));
    }

    @Test
    public void example2() {
        int[][] tasks = UtUtils.stringToInts2("[[1,3,2],[2,5,3],[5,6,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solution6318.findMinimumTime(tasks));
    }
}