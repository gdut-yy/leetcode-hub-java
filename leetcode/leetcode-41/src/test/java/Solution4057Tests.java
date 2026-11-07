import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4057Tests {
    private final Solution4057 solution4057 = new Solution4057();

    @Test
    public void example1() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}};
        long expected = 2;
        Assertions.assertEquals(expected, solution4057.countIntersectingIntervals(intervals));
    }

    @Test
    public void example2() {
        int[][] intervals = {{1, 5}, {2, 4}, {3, 6}};
        long expected = 3;
        Assertions.assertEquals(expected, solution4057.countIntersectingIntervals(intervals));
    }

    @Test
    public void example3() {
        int[][] intervals = {{1, 2}, {3, 4}, {5, 6}};
        long expected = 0;
        Assertions.assertEquals(expected, solution4057.countIntersectingIntervals(intervals));
    }
}
