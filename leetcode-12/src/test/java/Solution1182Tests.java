import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1182Tests {
    private final Solution1182 solution1182 = new Solution1182();

    @Test
    public void example1() {
        int[] colors = {1, 1, 2, 1, 3, 2, 2, 3, 3};
        int[][] queries = {{1, 3}, {2, 2}, {6, 1}};
        List<Integer> expected = List.of(3, 0, 3);
        Assertions.assertEquals(expected, solution1182.shortestDistanceColor(colors, queries));
    }

    @Test
    public void example2() {
        int[] colors = {1, 2};
        int[][] queries = {{0, 3}};
        List<Integer> expected = List.of(-1);
        Assertions.assertEquals(expected, solution1182.shortestDistanceColor(colors, queries));
    }
}
