import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Ccbft211029T2Tests {
    private final Ccbft211029T2 ccbft211029T2 = new Ccbft211029T2();

    @Test
    public void example1() {
        int[] heights = {3, 2, 7, 6, 1, 8};
        int cnt = 3;
        int[] expected = {1, 2, 3};
        Assertions.assertArrayEquals(expected, ccbft211029T2.analysisHistogram(heights, cnt));
    }

    @Test
    public void example2() {
        int[] heights = {4, 6, 1, 8, 4, 10};
        int cnt = 4;
        int[] expected = {4, 4, 6, 8};
        Assertions.assertArrayEquals(expected, ccbft211029T2.analysisHistogram(heights, cnt));
    }
}
