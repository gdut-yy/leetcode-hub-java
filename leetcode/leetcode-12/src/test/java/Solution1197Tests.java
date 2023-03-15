import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1197Tests {
    private final Solution1197 solution1197 = new Solution1197();

    @Test
    public void example1() {
        int x = 2;
        int y = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution1197.minKnightMoves(x, y));
    }

    @Test
    public void example2() {
        int x = 5;
        int y = 5;
        int expected = 4;
        Assertions.assertEquals(expected, solution1197.minKnightMoves(x, y));
    }
}