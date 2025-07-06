import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3609Tests {
    private final Solution3609 solution3609 = new Solution3609();

    @Test
    public void example1() {
        int sx = 1;
        int sy = 2;
        int tx = 5;
        int ty = 4;
        int expected = 2;
        Assertions.assertEquals(expected, solution3609.minMoves(sx, sy, tx, ty));
    }

    @Test
    public void example2() {
        int sx = 0;
        int sy = 1;
        int tx = 2;
        int ty = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution3609.minMoves(sx, sy, tx, ty));
    }

    @Test
    public void example3() {
        int sx = 1;
        int sy = 1;
        int tx = 2;
        int ty = 2;
        int expected = -1;
        Assertions.assertEquals(expected, solution3609.minMoves(sx, sy, tx, ty));
    }
}