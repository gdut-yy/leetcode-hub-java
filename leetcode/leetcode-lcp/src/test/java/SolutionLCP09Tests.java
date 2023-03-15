import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP09Tests {
    private final SolutionLCP09 solutionLCP09 = new SolutionLCP09();

    @Test
    public void example1() {
        int[] jump = new int[]{2, 5, 1, 1, 1, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solutionLCP09.minJump(jump));
        Assertions.assertEquals(expected, solutionLCP09.minJump2(jump));
        Assertions.assertEquals(expected, solutionLCP09.minJump3(jump));
    }

    // 补充用例
    @Test
    public void example2() {
        // https://leetcode.cn/submissions/detail/361399806/
        // MLE
        int[] jump = UtUtils.loadingInts("lcp/09/example2.txt", 0);
        int expected = 133;
        Assertions.assertEquals(expected, solutionLCP09.minJump(jump));
        Assertions.assertEquals(expected, solutionLCP09.minJump2(jump));
        Assertions.assertEquals(expected, solutionLCP09.minJump3(jump));
    }
}