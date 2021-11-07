import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Jianxin002Tests {
    private final Jianxin002 jianxin002 = new Jianxin002();

    @Test
    public void example1() {
        int[] heights = {3, 2, 7, 6, 1, 8};
        int cnt = 3;
        int[] expected = {1, 2, 3};
        Assertions.assertArrayEquals(expected, jianxin002.analysisHistogram(heights, cnt));
    }

    @Test
    public void example2() {
        int[] heights = {4, 6, 1, 8, 4, 10};
        int cnt = 4;
        int[] expected = {4, 4, 6, 8};
        Assertions.assertArrayEquals(expected, jianxin002.analysisHistogram(heights, cnt));
    }
}
