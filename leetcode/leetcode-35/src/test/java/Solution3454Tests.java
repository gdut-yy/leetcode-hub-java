import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3454Tests {
    private final Solution3454 solution3454 = new Solution3454();
    // 答案如果与实际答案的误差在 10^-5 以内，将视为正确答案。
    private static final double DELTA = 1e-5;

    @Test
    public void example1() {
        int[][] squares = UtUtils.stringToInts2("[[0,0,1],[2,2,1]]");
        double expected = 1.00000;
        Assertions.assertEquals(expected, solution3454.separateSquares(squares));
    }

    @Test
    public void example2() {
        int[][] squares = UtUtils.stringToInts2("[[0,0,2],[1,1,1]]");
        double expected = 1.00000;
        Assertions.assertEquals(expected, solution3454.separateSquares(squares));
    }
}