import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution417Tests {
    private final Solution417 solution417 = new Solution417();

    @Test
    public void example1() {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        List<List<Integer>> expected = new ArrayList<>(List.of(List.of(0, 4), List.of(1, 3), List.of(1, 4),
                List.of(2, 2), List.of(3, 0), List.of(3, 1), List.of(4, 0)));
        List<List<Integer>> actual = solution417.pacificAtlantic(heights);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
