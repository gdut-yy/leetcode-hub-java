import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution3975Tests {
    private final Solution3975 solution3975 = new Solution3975();

    @Test
    public void example1() {
        int[][] occupiedIntervals = UtUtils.stringToInts2("[[2,6],[4,8],[10,10],[10,12],[14,16]]");
        int freeStart = 7;
        int freeEnd = 11;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[2,6],[12,12],[14,16]]");
        Assertions.assertEquals(expected, solution3975.filterOccupiedIntervals(occupiedIntervals, freeStart, freeEnd));
    }

    @Test
    public void example2() {
        int[][] occupiedIntervals = UtUtils.stringToInts2("[[1,5],[2,3]]");
        int freeStart = 3;
        int freeEnd = 8;
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,2]]");
        Assertions.assertEquals(expected, solution3975.filterOccupiedIntervals(occupiedIntervals, freeStart, freeEnd));
    }
}