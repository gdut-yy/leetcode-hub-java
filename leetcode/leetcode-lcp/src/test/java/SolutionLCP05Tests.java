import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP05Tests {
    private final SolutionLCP05 solutionLCP05 = new SolutionLCP05();

    @Test
    public void example1() {
        int n = 6;
        int[][] leadership = UtUtils.stringToInts2("[[1, 2], [1, 6], [2, 3], [2, 5], [1, 4]]");
        int[][] operations = UtUtils.stringToInts2("[[1, 1, 500], [2, 2, 50], [3, 1], [2, 6, 15], [3, 1]]");
        int[] expected = {650, 665};
        Assertions.assertArrayEquals(expected, solutionLCP05.bonus(n, leadership, operations));
    }

    // 补充用例
    @Test
    public void example2() {
        // https://leetcode.cn/submissions/detail/359946276/
        // 爆 int -Xss10m
        String fileName = "lcp/05/example2.txt";
        int n = UtUtils.loadingInt(fileName, 0);
        int[][] leadership = UtUtils.loadingInts2(fileName, 1);
        int[][] operations = UtUtils.loadingInts2(fileName, 2);
        int[] expected = UtUtils.loadingInts("lcp/05/example2-expected.txt", 0);
        Assertions.assertArrayEquals(expected, solutionLCP05.bonus(n, leadership, operations));
    }
}
