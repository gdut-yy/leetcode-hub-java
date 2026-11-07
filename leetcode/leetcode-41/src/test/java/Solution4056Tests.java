import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4056Tests {
    private final Solution4056 solution4056 = new Solution4056();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[1,2],[2,3],[3,4]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution4056.countIntersectingIntervals(intervals));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[[1,5],[2,4],[3,6]]");
        int expected = 3;
        Assertions.assertEquals(expected, solution4056.countIntersectingIntervals(intervals));
    }

    @Test
    public void example3() {
        int[][] intervals = UtUtils.stringToInts2("[[1,2],[3,4],[5,6]]");
        int expected = 0;
        Assertions.assertEquals(expected, solution4056.countIntersectingIntervals(intervals));
    }
}
