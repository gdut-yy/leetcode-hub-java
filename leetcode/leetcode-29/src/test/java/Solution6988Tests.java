import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution6988Tests {
    private final Solution6988 solution6988 = new Solution6988();

    @Test
    public void example1() {
        List<List<Integer>> coordinates = UtUtils.stringToIntegerList2("[[1,2],[4,2],[1,3],[5,2]]");
        int k = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution6988.countPairs(coordinates, k));
    }

    @Test
    public void example2() {
        List<List<Integer>> coordinates = UtUtils.stringToIntegerList2("[[1,3],[1,3],[1,3],[1,3],[1,3]]");
        int k = 0;
        int expected = 10;
        Assertions.assertEquals(expected, solution6988.countPairs(coordinates, k));
    }
}