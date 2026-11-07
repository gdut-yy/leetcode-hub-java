import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4061Tests {
    private final Solution4061 solution4061 = new Solution4061();

    @Test
    public void example1() {
        int[] source = {8, 1};
        int[] target = {1, 8};
        int expected = 1;
        Assertions.assertEquals(expected, solution4061.minQueenMoves(source, target));
    }

    @Test
    public void example2() {
        int[] source = {4, 2};
        int[] target = {1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution4061.minQueenMoves(source, target));
    }

    @Test
    public void example3() {
        int[] source = {1, 1};
        int[] target = {1, 1};
        int expected = 0;
        Assertions.assertEquals(expected, solution4061.minQueenMoves(source, target));
    }
}
