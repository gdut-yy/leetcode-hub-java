package template;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PrefixSumTests {
    @Test
    public void testPrefixSum() {
        PrefixSum prefixSum = new PrefixSum(new int[]{-2, 0, 3, -5, 2, -1});
        Assertions.assertEquals(1, prefixSum.sumRange(0, 2));
        Assertions.assertEquals(-1, prefixSum.sumRange(2, 5));
        Assertions.assertEquals(-3, prefixSum.sumRange(0, 5));
    }

    @Test
    public void testDiff2d() {
        PrefixSum diff = new PrefixSum(new int[5]);
        diff.rangeAdd(1, 3, 2);
        diff.rangeAdd(2, 4, 3);
        diff.rangeAdd(0, 2, -2);
        int[] expected = {-2, 0, 3, 5, 3};
        Assertions.assertArrayEquals(expected, diff.originalArray());
    }
}