import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution252Tests {
    private final Solution252 solution252 = new Solution252();

    @Test
    public void example1() {
        int[][] intervals = UtUtils.stringToInts2("[[0,30],[5,10],[15,20]]");
        Assertions.assertFalse(solution252.canAttendMeetings(intervals));
        Assertions.assertFalse(solution252.canAttendMeetings2(intervals));
    }

    @Test
    public void example2() {
        int[][] intervals = UtUtils.stringToInts2("[[7,10],[2,4]]");
        Assertions.assertTrue(solution252.canAttendMeetings(intervals));
        Assertions.assertTrue(solution252.canAttendMeetings2(intervals));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/225516763/
        int[][] intervals = UtUtils.stringToInts2("[]");
        Assertions.assertTrue(solution252.canAttendMeetings(intervals));
        Assertions.assertTrue(solution252.canAttendMeetings2(intervals));
    }
}
