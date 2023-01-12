import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution356Tests {
    private final Solution356 solution356 = new Solution356();

    @Test
    public void example1() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[-1,1]]");
        Assertions.assertTrue(solution356.isReflected(points));
    }

    @Test
    public void example2() {
        int[][] points = UtUtils.stringToInts2("[[1,1],[-1,-1]]");
        Assertions.assertFalse(solution356.isReflected(points));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/394848258/
        // 一个点也行
        int[][] points = UtUtils.stringToInts2("[[0,0]]");
        Assertions.assertTrue(solution356.isReflected(points));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/394849183/
        // 重复的点
        int[][] points = UtUtils.stringToInts2("[[-16,1],[16,1],[16,1]]");
        Assertions.assertTrue(solution356.isReflected(points));
    }
}
