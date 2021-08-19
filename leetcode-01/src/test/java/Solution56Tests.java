import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution56Tests {
    private final Solution56 solution56 = new Solution56();

    @Test
    public void example1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        Assertions.assertArrayEquals(expected, solution56.merge(intervals));
    }

    @Test
    public void example2() {
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] expected = {{1, 5}};
        Assertions.assertArrayEquals(expected, solution56.merge(intervals));
    }
}
