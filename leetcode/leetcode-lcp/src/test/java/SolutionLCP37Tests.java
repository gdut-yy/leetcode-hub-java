import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP37Tests {
    private final SolutionLCP37 solutionLCP37 = new SolutionLCP37();
    // 注意：返回结果是浮点数，与标准答案 绝对误差或相对误差 在 10^-4 以内的结果都被视为正确结果
    private static final double DELTA = 1e-4;

    @Test
    public void example1() {
        int[][] lines = UtUtils.stringToInts2("[[2,3],[3,0],[4,1]]");
        double expected = 48.00000;
        Assertions.assertEquals(expected, solutionLCP37.minRecSize(lines), DELTA);
    }

    @Test
    public void example2() {
        int[][] lines = UtUtils.stringToInts2("[[1,1],[2,3]]");
        double expected = 0.00000;
        Assertions.assertEquals(expected, solutionLCP37.minRecSize(lines), DELTA);
    }
}
