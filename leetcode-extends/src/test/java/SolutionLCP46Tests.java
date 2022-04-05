import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionLCP46Tests {
    private final SolutionLCP46 solutionLCP46 = new SolutionLCP46();

    @Test
    public void example1() {
        int[] finalCnt = {1, 16};
        long totalNum = 21;
        int[][] edges = UtUtils.stringToInts2("[[0,1],[1,2]]");
        int[][] plans = UtUtils.stringToInts2("[[2,1],[1,0],[3,0]]");
        int[] expected = {5, 7, 9};
        Assertions.assertArrayEquals(expected, solutionLCP46.volunteerDeployment(finalCnt, totalNum, edges, plans));
        Assertions.assertArrayEquals(expected, solutionLCP46.volunteerDeployment2(finalCnt, totalNum, edges, plans));
    }

    @Test
    public void example2() {
        int[] finalCnt = {4, 13, 4, 3, 8};
        long totalNum = 54;
        int[][] edges = UtUtils.stringToInts2("[[0,3],[1,3],[4,3],[2,3],[2,5]]");
        int[][] plans = UtUtils.stringToInts2("[[1,1],[3,3],[2,5],[1,0]]");
        int[] expected = {10, 16, 9, 4, 7, 8};
        Assertions.assertArrayEquals(expected, solutionLCP46.volunteerDeployment(finalCnt, totalNum, edges, plans));
        Assertions.assertArrayEquals(expected, solutionLCP46.volunteerDeployment2(finalCnt, totalNum, edges, plans));
    }

    // 补充用例
    @Test
    public void example3() {
        final String fileName = "lcp/46/example3.txt";
        int[] finalCnt = UtUtils.loadingInts(fileName, 0);
        long totalNum = UtUtils.loadingLong(fileName, 1);
        int[][] edges = UtUtils.loadingInts2(fileName, 2);
        int[][] plans = UtUtils.loadingInts2(fileName, 3);
        // -174x = -1984282602
        // x = 11403923
        int[] expected = UtUtils.loadingInts("lcp/46/example3-expected.txt", 0);
        Assertions.assertArrayEquals(expected, solutionLCP46.volunteerDeployment(finalCnt, totalNum, edges, plans));
        Assertions.assertArrayEquals(expected, solutionLCP46.volunteerDeployment2(finalCnt, totalNum, edges, plans));
    }

    @Test
    public void example4() {
        final String fileName = "lcp/46/example4.txt";
        int[] finalCnt = UtUtils.loadingInts(fileName, 0);
        long totalNum = UtUtils.loadingLong(fileName, 1);
        int[][] edges = UtUtils.loadingInts2(fileName, 2);
        int[][] plans = UtUtils.loadingInts2(fileName, 3);
        // -26628x = -1249099056324
        // x = 46909233
        int[] expected = UtUtils.loadingInts("lcp/46/example4-expected.txt", 0);
        Assertions.assertArrayEquals(expected, solutionLCP46.volunteerDeployment(finalCnt, totalNum, edges, plans));
        Assertions.assertArrayEquals(expected, solutionLCP46.volunteerDeployment2(finalCnt, totalNum, edges, plans));
    }

    @Test
    public void example5() {
        final String fileName = "lcp/46/example5.txt";
        int[] finalCnt = UtUtils.loadingInts(fileName, 0);
        long totalNum = UtUtils.loadingLong(fileName, 1);
        int[][] edges = UtUtils.loadingInts2(fileName, 2);
        int[][] plans = UtUtils.loadingInts2(fileName, 3);
        // 4x = 7877992
        // x = 1969498
        int[] expected = UtUtils.loadingInts("lcp/46/example5-expected.txt", 0);
        Assertions.assertArrayEquals(expected, solutionLCP46.volunteerDeployment(finalCnt, totalNum, edges, plans));
        Assertions.assertArrayEquals(expected, solutionLCP46.volunteerDeployment2(finalCnt, totalNum, edges, plans));
    }
}
