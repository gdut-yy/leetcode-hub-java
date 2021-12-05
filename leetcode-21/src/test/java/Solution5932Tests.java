import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution5932Tests {
    private final Solution5932 solution5932 = new Solution5932();

    @Test
    public void example1() {
        int[][] pairs = {{5, 1}, {4, 5}, {11, 9}, {9, 4}};
        int[][] expected = {{11, 9}, {9, 4}, {4, 5}, {5, 1}};
        Assertions.assertArrayEquals(expected, solution5932.validArrangement(pairs));
    }

    @Test
    public void example2() {
        int[][] pairs = {{1, 3}, {3, 2}, {2, 1}};
        int[][] expected = {{1, 3}, {3, 2}, {2, 1}};
        Assertions.assertArrayEquals(expected, solution5932.validArrangement(pairs));
    }

    @Test
    public void example3() {
        int[][] pairs = {{1, 2}, {1, 3}, {2, 1}};
        int[][] expected = {{1, 2}, {2, 1}, {1, 3}};
        Assertions.assertArrayEquals(expected, solution5932.validArrangement(pairs));
    }
}
