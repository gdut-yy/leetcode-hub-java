import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1940Tests {
    private final Solution1940 solution1940 = new Solution1940();

    @Test
    public void example1() {
        int[][] arrays = UtUtils.stringToInts2("[[1,3,4],[1,4,7,9]]");
        List<Integer> expected = List.of(1, 4);
        Assertions.assertEquals(expected, solution1940.longestCommonSubsequence(arrays));
    }

    @Test
    public void example2() {
        int[][] arrays = UtUtils.stringToInts2("[[2,3,6,8],[1,2,3,5,6,7,10],[2,3,4,6,9]]");
        List<Integer> expected = List.of(2, 3, 6);
        Assertions.assertEquals(expected, solution1940.longestCommonSubsequence(arrays));
    }

    @Test
    public void example3() {
        int[][] arrays = UtUtils.stringToInts2("[[1,2,3,4,5],[6,7,8]]");
        List<Integer> expected = List.of();
        Assertions.assertEquals(expected, solution1940.longestCommonSubsequence(arrays));
    }
}