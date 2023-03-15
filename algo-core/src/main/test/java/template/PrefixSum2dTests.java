package template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrefixSum2dTests {
    @Test
    public void testPrefixSum2d() {
        // @see Solution304
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        PrefixSum2d prefixSum2d = new PrefixSum2d(matrix);
        Assertions.assertEquals(8, prefixSum2d.sumRegion(2, 1, 4, 3));
        Assertions.assertEquals(11, prefixSum2d.sumRegion(1, 1, 2, 2));
        Assertions.assertEquals(12, prefixSum2d.sumRegion(1, 2, 2, 4));
    }

    @Test
    public void testDiff2d() {
        int[][] grid = new int[3][3];
        PrefixSum2d diff2d = new PrefixSum2d(grid);
        diff2d.rangeAdd(0, 0, 2, 2, 1);
        diff2d.rangeAdd(0, 0, 1, 1, 1);
        int[][] expected = {{2, 2, 1}, {2, 2, 1}, {1, 1, 1}};
        Assertions.assertArrayEquals(expected, diff2d.originalArray());
    }
}