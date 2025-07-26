import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1467Tests {
    private final Solution1467.V1 solution1467_v1 = new Solution1467.V1();
    private final Solution1467.V2 solution1467_v2 = new Solution1467.V2();
    private static final double DELTA = 1e-5;

    @Test
    public void example1() {
        int[] balls = {1, 1};
        double expected = 1.00000;
        Assertions.assertEquals(expected, solution1467_v1.getProbability(balls), DELTA);
        Assertions.assertEquals(expected, solution1467_v2.getProbability(balls), DELTA);
    }

    @Test
    public void example2() {
        int[] balls = {2, 1, 1};
        double expected = 0.66667;
        Assertions.assertEquals(expected, solution1467_v1.getProbability(balls), DELTA);
        Assertions.assertEquals(expected, solution1467_v2.getProbability(balls), DELTA);
    }

    @Test
    public void example3() {
        int[] balls = {1, 2, 1, 2};
        double expected = 0.60000;
        Assertions.assertEquals(expected, solution1467_v1.getProbability(balls), DELTA);
        Assertions.assertEquals(expected, solution1467_v2.getProbability(balls), DELTA);
    }
}