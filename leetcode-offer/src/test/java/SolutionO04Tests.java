import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionO04Tests {
    private final SolutionO04 solutionO04 = new SolutionO04();

    @Test
    public void example1() {
        int[][] matrix = UtUtils.stringToInts2("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]");
        int target = 5;
        Assertions.assertTrue(solutionO04.findNumberIn2DArray(matrix, target));
    }

    @Test
    public void example2() {
        int[][] matrix = UtUtils.stringToInts2("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]");
        int target = 20;
        Assertions.assertFalse(solutionO04.findNumberIn2DArray(matrix, target));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/230133678/
        int[][] matrix = UtUtils.stringToInts2("[]");
        int target = 0;
        Assertions.assertFalse(solutionO04.findNumberIn2DArray(matrix, target));
    }
}
