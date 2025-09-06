import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionP3416Tests {
    private final SolutionP3416 solutionP3416 = new SolutionP3416();

    @Test
    public void example1() {
        int[] nums = {1, 1, 1, 1, 1, 1};
        int expected = 6;
        Assertions.assertEquals(expected, solutionP3416.subsequencesWithMiddleMode(nums));
    }

    @Test
    public void example2() {
        int[] nums = {1, 2, 2, 3, 3, 4};
        int expected = 4;
        Assertions.assertEquals(expected, solutionP3416.subsequencesWithMiddleMode(nums));
    }

    @Test
    public void example3() {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int expected = 0;
        Assertions.assertEquals(expected, solutionP3416.subsequencesWithMiddleMode(nums));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/problems/subsequences-with-a-unique-middle-mode-ii/submissions/658157607/
        // 爆 long
        int[] nums = UtUtils.loadingInts("solution3416-example4-input.txt", 0);
        int expected = 400731790;
        Assertions.assertEquals(expected, solutionP3416.subsequencesWithMiddleMode(nums));
    }
}