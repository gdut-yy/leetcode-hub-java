import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP24Tests {
    private final SolutionLCP24 solutionLCP24 = new SolutionLCP24();

    @Test
    public void example1() {
        int[] nums = {3, 4, 5, 1, 6, 7};
        int[] expected = {0, 0, 0, 5, 6, 7};
        Assertions.assertArrayEquals(expected, solutionLCP24.numsGame(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {0, 0, 0, 0, 0};
        Assertions.assertArrayEquals(expected, solutionLCP24.numsGame(nums));
    }

    @Test
    public void example3() {
        int[] nums = {1, 1, 1, 2, 3, 4};
        int[] expected = {0, 1, 2, 3, 3, 3};
        Assertions.assertArrayEquals(expected, solutionLCP24.numsGame(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/387453705/
        // 爆 int
        int[] nums = UtUtils.loadingInts("lcp/24/example4.txt", 0);
        int[] expected = UtUtils.loadingInts("lcp/24/example4-expected.txt", 0);
        Assertions.assertArrayEquals(expected, solutionLCP24.numsGame(nums));
    }
}
