import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3680Tests {
    private final Solution3680 solution3680 = new Solution3680();

    @Test
    public void example1() {
        int n = 3;
        int[][] expected = UtUtils.stringToInts2("[]");
        Assertions.assertArrayEquals(expected, solution3680.generateSchedule(n));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] expected = UtUtils.stringToInts2("[[0,1],[2,3],[0,4],[1,2],[3,4],[0,2],[1,3],[2,4],[0,3],[1,4],[2,0],[3,1],[4,0],[2,1],[4,3],[1,0],[3,2],[4,1],[3,0],[4,2]]");
        // 答案不唯一
//        Assertions.assertArrayEquals(expected, solution3680.generateSchedule(n));
    }
}