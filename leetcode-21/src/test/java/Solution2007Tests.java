import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution2007Tests {
    private final Solution2007 solution2007 = new Solution2007();

    @Test
    public void example1() {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] expected = {1, 3, 4};
        int[] actual = solution2007.findOriginalArray(changed);
        Arrays.sort(actual);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example2() {
        int[] changed = {6, 3, 0, 1};
        int[] expected = {};
        int[] actual = solution2007.findOriginalArray(changed);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void example3() {
        int[] changed = {1};
        int[] expected = {};
        int[] actual = solution2007.findOriginalArray(changed);
        Arrays.sort(actual);
        Assertions.assertArrayEquals(expected, actual);
    }
}
