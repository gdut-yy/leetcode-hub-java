import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SolutionLCP63Tests {
    private final SolutionLCP63 solutionLCP63 = new SolutionLCP63();

    @Test
    public void example1() {
        int num = 4;
        String[] plate = {"..E.", ".EOW", "..W."};
        int[][] expected = UtUtils.stringToInts2("[[2,1]]");
        int[][] actual = solutionLCP63.ballGame(num, plate);
        Arrays.sort(expected, UtUtils.INTS2_COMPARATOR);
        Arrays.sort(actual, UtUtils.INTS2_COMPARATOR);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int num = 5;
        String[] plate = {".....", "..E..", ".WO..", "....."};
        int[][] expected = UtUtils.stringToInts2("[[0,1],[1,0],[2,4],[3,2]]");
        int[][] actual = solutionLCP63.ballGame(num, plate);
        Arrays.sort(expected, UtUtils.INTS2_COMPARATOR);
        Arrays.sort(actual, UtUtils.INTS2_COMPARATOR);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example3() {
        int num = 3;
        String[] plate = {".....", "....O", "....O", "....."};
        int[][] expected = UtUtils.stringToInts2("[]");
        int[][] actual = solutionLCP63.ballGame(num, plate);
        Arrays.sort(expected, UtUtils.INTS2_COMPARATOR);
        Arrays.sort(actual, UtUtils.INTS2_COMPARATOR);
        Assertions.assertArrayEquals(expected, actual);
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/366724728/
        int num = UtUtils.loadingInt("lcp/63/example4.txt", 0);
        String[] plate = UtUtils.loadingStrings("lcp/63/example4.txt", 1);
        int[][] expected = UtUtils.loadingInts2("lcp/63/example4-expected.txt", 0);
        int[][] actual = solutionLCP63.ballGame(num, plate);
        Arrays.sort(expected, UtUtils.INTS2_COMPARATOR);
        Arrays.sort(actual, UtUtils.INTS2_COMPARATOR);
        Assertions.assertArrayEquals(expected, actual);
    }
}
