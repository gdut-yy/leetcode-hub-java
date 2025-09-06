import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution3669Tests {
    private final Solution3669 solution3669 = new Solution3669();

    @Test
    public void example1() {
        int n = 100;
        int k = 2;
        int[] expected = {10, 10};
        int[] actual = solution3669.minDifference(n, k);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int n = 44;
        int k = 3;
        int[] expected = {2, 2, 11};
        int[] actual = solution3669.minDifference(n, k);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}