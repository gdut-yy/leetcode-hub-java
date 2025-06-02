import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3552Tests {
    private final Solution3552 solution3552 = new Solution3552();

    @Test
    public void example1() {
        String[] matrix = {"A..", ".A.", "..."};
        int expected = 2;
        Assertions.assertEquals(expected, solution3552.minMoves(matrix));
    }

    @Test
    public void example2() {
        String[] matrix = {".#...", ".#.#.", ".#.#.", "...#."};
        int expected = 13;
        Assertions.assertEquals(expected, solution3552.minMoves(matrix));
    }
}