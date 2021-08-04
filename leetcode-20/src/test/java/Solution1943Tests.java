import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1943Tests {
    private final Solution1943 solution1943 = new Solution1943();

    @Test
    public void example1() {
        int[][] segments = {{1, 4, 5}, {4, 7, 7}, {1, 7, 9}};
        List<List<Long>> expected = List.of(List.of(1L, 4L, 14L), List.of(4L, 7L, 16L));
        Assertions.assertEquals(expected, solution1943.splitPainting(segments));
    }

    @Test
    public void example2() {
        int[][] segments = {{1, 7, 9}, {6, 8, 15}, {8, 10, 7}};
        List<List<Long>> expected = List.of(List.of(1L, 6L, 9L), List.of(6L, 7L, 24L), List.of(7L, 8L, 15L), List.of(8L, 10L, 7L));
        Assertions.assertEquals(expected, solution1943.splitPainting(segments));
    }

    @Test
    public void example3() {
        int[][] segments = {{1, 4, 5}, {1, 4, 7}, {4, 7, 1}, {4, 7, 11}};
        List<List<Long>> expected = List.of(List.of(1L, 4L, 12L), List.of(4L, 7L, 12L));
        Assertions.assertEquals(expected, solution1943.splitPainting(segments));
    }
}
