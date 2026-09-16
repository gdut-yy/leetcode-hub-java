import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution4001Tests {
    private final Solution4001 solution4001 = new Solution4001();

    @Test
    public void example1() {
        int[][] series1 = UtUtils.stringToInts2("[[1,3],[4,1]]");
        int[][] series2 = UtUtils.stringToInts2("[[2,2],[5,2]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,5],[2,3],[4,3],[5,2]]");
        Assertions.assertEquals(expected, solution4001.aggregateTimeSeries(series1, series2));
    }

    @Test
    public void example2() {
        int[][] series1 = UtUtils.stringToInts2("[[1,5],[3,1]]");
        int[][] series2 = UtUtils.stringToInts2("[[2,2]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,7],[2,3],[3,1]]");
        Assertions.assertEquals(expected, solution4001.aggregateTimeSeries(series1, series2));
    }

    @Test
    public void example3() {
        int[][] series1 = UtUtils.stringToInts2("[[1,5]]");
        int[][] series2 = UtUtils.stringToInts2("[[1000000000,2]]");
        List<List<Integer>> expected = UtUtils.stringToIntegerList2("[[1,7],[1000000000,2]]");
        Assertions.assertEquals(expected, solution4001.aggregateTimeSeries(series1, series2));
    }
}