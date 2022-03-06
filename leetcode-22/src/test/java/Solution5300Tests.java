import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution5300Tests {
    private final Solution5300 solution5300 = new Solution5300();

    @Test
    public void example1() {
        int n = 8;
        int[][] edges = {{0, 3}, {0, 4}, {1, 3}, {2, 4}, {2, 7}, {3, 5}, {3, 6}, {3, 7}, {4, 6}};
        List<List<Integer>> expected = List.of(List.of(), List.of(), List.of(),
                List.of(0, 1), List.of(0, 2), List.of(0, 1, 3), List.of(0, 1, 2, 3, 4), List.of(0, 1, 2, 3));
        Assertions.assertEquals(expected, solution5300.getAncestors(n, edges));
    }

    @Test
    public void example2() {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {1, 2}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
        List<List<Integer>> expected = List.of(List.of(), List.of(0), List.of(0, 1), List.of(0, 1, 2), List.of(0, 1, 2, 3));
        Assertions.assertEquals(expected, solution5300.getAncestors(n, edges));
    }

    // 补充用例
    @Test
    public void example3() {
        int n = UtUtils.loadingInt("solution5300-example3-input.txt", 0);
        int[][] edges = UtUtils.loadingInts2("solution5300-example3-input.txt", 1);
        List<List<Integer>> expected = UtUtils.loadingIntegerList2("solution5300-example3-output.txt", 0);
        Assertions.assertEquals(expected, solution5300.getAncestors(n, edges));
    }
}
