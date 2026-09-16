import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4034Tests {
    private final Solution4034 solution4034 = new Solution4034();

    @Test
    public void example1() {
        int[] source = {8, 1};
        int[] target = {1, 8};
        int expected = 1;
        Assertions.assertEquals(expected, solution4034.minBishopMoves(source, target));
    }

    @Test
    public void example2() {
        int[] source = {4, 2};
        int[] target = {1, 3};
        int expected = 2;
        Assertions.assertEquals(expected, solution4034.minBishopMoves(source, target));
    }

    @Test
    public void example3() {
        int[] source = {1, 1};
        int[] target = {3, 4};
        int expected = -1;
        Assertions.assertEquals(expected, solution4034.minBishopMoves(source, target));
    }
}