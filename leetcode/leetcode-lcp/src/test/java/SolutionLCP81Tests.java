import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP81Tests {
    private final SolutionLCP81 solutionLCP81 = new SolutionLCP81();

    @Test
    public void example1() {
        int k = 3;
        int[] arr = {1, 2};
        int[][] operations = UtUtils.stringToInts2("[[1,2,3],[0,0,3],[1,2,2]]");
        int expected = 2;
        Assertions.assertEquals(expected, solutionLCP81.getNandResult(k, arr, operations));
    }

    @Test
    public void example2() {
        int k = 4;
        int[] arr = {4, 6, 4, 7, 10, 9, 11};
        int[][] operations = UtUtils.stringToInts2("[[1,5,7],[1,7,14],[0,6,7],[1,6,5]]");
        int expected = 9;
        Assertions.assertEquals(expected, solutionLCP81.getNandResult(k, arr, operations));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/430514903/ TLE
        String fileName = "lcp/81/example3.txt";
        int k = UtUtils.loadingInt(fileName, 0);
        int[] arr = UtUtils.loadingInts(fileName, 1);
        int[][] operations = UtUtils.loadingInts2(fileName, 2);
        int expected = 16378;
        Assertions.assertEquals(expected, solutionLCP81.getNandResult(k, arr, operations));
    }

    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/430516833/ WA
        int k = 5;
        int[] arr = {27, 31, 31, 15, 15, 27, 27, 11, 15};
        int[][] operations = UtUtils.stringToInts2("[[1,10,1],[0,5,4],[0,0,12],[0,7,28],[1,10,4],[0,8,29],[1,8,7],[0,1,4],[0,2,24],[1,10,13]]");
        int expected = 5;
        Assertions.assertEquals(expected, solutionLCP81.getNandResult(k, arr, operations));
    }

    @Test
    public void example5() {
        // https://leetcode.cn/submissions/detail/430517712/ WA
        int k = 3;
        int[] arr = {3, 7, 3, 7, 3, 7, 3, 3, 7, 3, 3, 7, 3, 7, 3, 3, 3, 3, 7, 3, 7, 7, 7, 7, 3, 3, 7, 3, 3, 3, 3, 7, 3, 7, 7, 3, 3, 7, 3, 3, 3, 3, 3, 3, 3, 7, 7, 3, 7, 7, 7, 3, 3, 7, 3, 3, 7, 7, 7, 7, 3, 3, 3, 3, 7, 7, 7, 3, 7, 3, 7, 3, 7, 7, 7, 7, 7, 3, 7, 7, 7, 7, 3, 3, 7, 7, 3};
        int[][] operations = UtUtils.stringToInts2("[[1,83,0],[0,78,4],[1,92,6],[1,80,5],[0,20,5],[0,44,3],[0,80,1],[0,46,4],[0,39,6],[1,80,2],[0,50,5],[1,95,2],[1,81,1],[1,92,7],[1,85,5],[0,45,7],[0,42,7],[1,80,3],[1,94,2],[0,79,5],[1,90,4],[0,74,0],[1,91,6],[1,95,1],[0,39,4],[1,87,1],[0,52,7],[1,80,3],[0,7,7],[0,73,7],[0,61,6],[0,13,5],[1,83,2],[1,98,4],[0,27,0],[1,99,2],[1,96,3],[1,89,1],[1,97,4],[1,93,2],[0,16,1],[1,99,7],[1,90,7],[0,27,2],[0,53,5],[1,95,7],[0,38,0],[1,94,3],[1,89,4],[0,22,5],[0,47,1],[1,88,1],[1,85,3],[1,88,1],[0,73,0],[0,63,5],[0,55,2],[1,83,7],[0,60,3],[1,92,4],[0,53,4],[1,88,3],[1,87,1],[1,99,5],[1,85,0],[0,76,0],[0,68,4],[0,14,1],[0,1,1],[0,26,3],[0,62,4],[1,92,6],[1,94,7],[1,100,1],[1,92,0],[1,81,7],[0,31,0],[1,91,3],[0,72,1],[0,79,7],[0,10,1],[1,85,2],[1,83,5],[1,93,0],[1,88,4],[1,89,6],[0,73,7],[0,28,7],[0,53,3],[0,19,4],[0,2,3],[1,91,0],[1,93,4],[1,99,4],[0,32,1],[1,98,3],[1,90,6]]");
        int expected = 0;
        Assertions.assertEquals(expected, solutionLCP81.getNandResult(k, arr, operations));
    }
}