import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution5235Tests {
    private final Solution5235 solution5235 = new Solution5235();

    @Test
    public void example1() {
        int[][] matches = UtUtils.stringToInts2("[[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2,10],[4,5,7,8]]");
        Assertions.assertEquals(expected, solution5235.findWinners(matches));
    }

    @Test
    public void example2() {
        int[][] matches = UtUtils.stringToInts2("[[2,3],[1,3],[5,4],[6,4]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2,5,6],[]]");
        Assertions.assertEquals(expected, solution5235.findWinners(matches));
    }
}
