import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution733Tests {
    private final Solution733 solution733 = new Solution733();

    @Test
    public void example1() {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        int[][] expected = {{2, 2, 2}, {2, 2, 0}, {2, 0, 1}};
        Assertions.assertArrayEquals(expected, solution733.floodFill(image, sr, sc, newColor));
    }
}
