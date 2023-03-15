import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP32Tests {
    private final SolutionLCP32 solutionLCP32 = new SolutionLCP32();

    @Test
    public void example1() {
        int[][] tasks = UtUtils.stringToInts2("[[1,3,2],[2,5,3],[5,6,2]]");
        int expected = 4;
        Assertions.assertEquals(expected, solutionLCP32.processTasks(tasks));
    }

    @Test
    public void example2() {
        int[][] tasks = UtUtils.stringToInts2("[[2,3,1],[5,5,1],[5,6,2]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP32.processTasks(tasks));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/412254410/
        // 下标为 0 情况
        int[][] tasks = UtUtils.stringToInts2("[[0,0,1],[1,1,1],[2,2,1]]");
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP32.processTasks(tasks));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/412265322/ TLE
        // 68 / 72 个通过测试用例
        int[][] tasks = UtUtils.loadingInts2("lcp/32/example4.txt", 0);
        int expected = 997940748;
        Assertions.assertEquals(expected, solutionLCP32.processTasks(tasks));
        Assertions.assertEquals(expected, solutionLCP32.processTasks2(tasks));
    }
}
