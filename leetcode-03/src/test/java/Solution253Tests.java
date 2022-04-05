import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution253Tests {
    private final Solution253 solution253 = new Solution253();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[0,30],[5,10],[15,20]]");
        int expected = 2;
        Assertions.assertEquals(expected, solution253.minMeetingRooms(intervals));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[[7,10],[2,4]]");
        int expected = 1;
        Assertions.assertEquals(expected, solution253.minMeetingRooms(intervals));
    }
}
