import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution5973Tests {
    private final Solution5973 solution5973 = new Solution5973();

    @Test
    public void example1() {
        int[][] grid = {{1, 2, 0, 1}, {1, 3, 0, 1}, {0, 2, 5, 1}};
        int[] pricing = {2, 5};
        int[] start = {0, 0};
        int k = 3;
        List<List<Integer>> expected = List.of(List.of(0, 1), List.of(1, 1), List.of(2, 1));
        Assertions.assertEquals(expected, solution5973.highestRankedKItems(grid, pricing, start, k));
    }

    @Test
    public void example2() {
        int[][] grid = {{1, 2, 0, 1}, {1, 3, 3, 1}, {0, 2, 5, 1}};
        int[] pricing = {2, 3};
        int[] start = {2, 3};
        int k = 2;
        List<List<Integer>> expected = List.of(List.of(2, 1), List.of(1, 2));
        Assertions.assertEquals(expected, solution5973.highestRankedKItems(grid, pricing, start, k));
    }

    @Test
    public void example3() {
        int[][] grid = {{1, 1, 1}, {0, 0, 1}, {2, 3, 4}};
        int[] pricing = {2, 3};
        int[] start = {0, 0};
        int k = 3;
        List<List<Integer>> expected = List.of(List.of(2, 1), List.of(2, 0));
        Assertions.assertEquals(expected, solution5973.highestRankedKItems(grid, pricing, start, k));
    }
}
