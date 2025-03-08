import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3453Tests {
    private final Solution3453.V1 solution3453_v1 = new Solution3453.V1();
    private final Solution3453.V2 solution3453_v2 = new Solution3453.V2();
    private final Solution3453.V3 solution3453_v3 = new Solution3453.V3();
    // 答案如果与实际答案的误差在 10^-5 以内，将视为正确答案。
    private static final double DELTA = 1e-5;

    @Test
    public void example1() {
        int[][] squares = UtUtils.stringToInts2("[[0,0,1],[2,2,1]]");
        double expected = 1.00000;
        Assertions.assertEquals(expected, solution3453_v1.separateSquares(squares), DELTA);
        Assertions.assertEquals(expected, solution3453_v2.separateSquares(squares), DELTA);
        Assertions.assertEquals(expected, solution3453_v3.separateSquares(squares), DELTA);
    }

    @Test
    public void example2() {
        int[][] squares = UtUtils.stringToInts2("[[0,0,2],[1,1,1]]");
        double expected = 1.16667;
        Assertions.assertEquals(expected, solution3453_v1.separateSquares(squares), DELTA);
        Assertions.assertEquals(expected, solution3453_v2.separateSquares(squares), DELTA);
        Assertions.assertEquals(expected, solution3453_v3.separateSquares(squares), DELTA);
    }

    // 赛后补充
    @Test
    public void example3() {
        // https://github.com/LeetCode-Feedback/LeetCode-Feedback/issues/27203
        int[][] squares = UtUtils.stringToInts2("[[0, 0, 999999999], [1000000000, 0, 999999999], [0, 999999999, 1], [0, 1000000000, 999999999], [1000000000, 1000000000, 999999999]]");
        double expected = 999999999.50000;
//        Assertions.assertEquals(expected, solution3453_v1.separateSquares(squares), DELTA);
        Assertions.assertEquals(expected, solution3453_v2.separateSquares(squares), DELTA);
        Assertions.assertEquals(expected, solution3453_v3.separateSquares(squares), DELTA);
    }

    @Test
    public void example4() {
        // https://github.com/LeetCode-Feedback/LeetCode-Feedback/issues/27191
        int[][] squares = UtUtils.stringToInts2("[[0,0,800000000],[0,890000000,1],[0,900000000,800000000]]");
        double expected = 890000000.5;
//        Assertions.assertEquals(expected, solution3453_v1.separateSquares(squares), DELTA);
        Assertions.assertEquals(expected, solution3453_v2.separateSquares(squares), DELTA);
        Assertions.assertEquals(expected, solution3453_v3.separateSquares(squares), DELTA);
    }
}