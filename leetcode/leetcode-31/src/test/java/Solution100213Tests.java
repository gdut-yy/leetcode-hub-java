import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100213Tests {
    private final Solution100213 solution100213 = new Solution100213();

    @Test
    public void example1() {
        int n = 3;
        int x = 1;
        int y = 3;
        long[] expected = {6, 0, 0};
        Assertions.assertArrayEquals(expected, solution100213.countOfPairs(n, x, y));
    }

    @Test
    public void example2() {
        int n = 5;
        int x = 2;
        int y = 4;
        long[] expected = {10, 8, 2, 0, 0};
        Assertions.assertArrayEquals(expected, solution100213.countOfPairs(n, x, y));
    }

    @Test
    public void example3() {
        int n = 4;
        int x = 1;
        int y = 1;
        long[] expected = {6, 4, 2, 0};
        Assertions.assertArrayEquals(expected, solution100213.countOfPairs(n, x, y));
    }
}