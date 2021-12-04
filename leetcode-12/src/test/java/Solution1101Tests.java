import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1101Tests {
    private final Solution1101 solution1101 = new Solution1101();

    @Test
    public void example1() {
        int[][] logs = {{20190101, 0, 1}, {20190104, 3, 4}, {20190107, 2, 3}, {20190211, 1, 5}, {20190224, 2, 4}, {20190301, 0, 3}, {20190312, 1, 2}, {20190322, 4, 5}};
        int n = 6;
        int expected = 20190301;
        Assertions.assertEquals(expected, solution1101.earliestAcq(logs, n));
    }
}
