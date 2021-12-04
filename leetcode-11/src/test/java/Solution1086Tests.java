import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1086Tests {
    private final Solution1086 solution1086 = new Solution1086();

    @Test
    public void example1() {
        int[][] items = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};
        int[][] expected = {{1, 87}, {2, 88}};
        Assertions.assertArrayEquals(expected, solution1086.highFive(items));
    }

    @Test
    public void example2() {
        int[][] items = {{1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}, {1, 100}, {7, 100}};
        int[][] expected = {{1, 100}, {7, 100}};
        Assertions.assertArrayEquals(expected, solution1086.highFive(items));
    }
}
