import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution1192Tests {
    private final Solution1192 solution1192 = new Solution1192();

    @Test
    public void example1() {
        int n = 4;
        List<List<Integer>> connections = List.of(List.of(0, 1), List.of(1, 2), List.of(2, 0), List.of(1, 3));
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 3));
        List<List<Integer>> actual = solution1192.criticalConnections(n, connections);
        expected.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        actual.sort(UtUtils.INTEGER_LIST_COMPARATOR);
        Assertions.assertEquals(expected, actual);
    }
}
