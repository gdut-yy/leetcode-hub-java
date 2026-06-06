import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3899Tests {
    private final Solution3899 solution3899 = new Solution3899();
    // 与真实答案的误差在 10^-5 以内的结果都将被视为正确。
    private static final double DELTA = 1e-5;

    @Test
    public void example1() {
        int[] sides = {3, 4, 5};
        double[] expected = {36.86990, 53.13010, 90.00000};
        Assertions.assertArrayEquals(expected, solution3899.internalAngles(sides), DELTA);
    }

    @Test
    public void example2() {
        int[] sides = {2, 4, 2};
        double[] expected = {};
        Assertions.assertArrayEquals(expected, solution3899.internalAngles(sides), DELTA);
    }
}