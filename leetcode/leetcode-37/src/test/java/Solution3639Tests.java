import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3639Tests {
    private final Solution3639 solution3639 = new Solution3639();

    @Test
    public void example1() {
        String s = "abc";
        int[] order = {1, 0, 2};
        int k = 2;
        int expected = 0;
        Assertions.assertEquals(expected, solution3639.minTime(s, order, k));
    }

    @Test
    public void example2() {
        String s = "cat";
        int[] order = {0, 2, 1};
        int k = 6;
        int expected = 2;
        Assertions.assertEquals(expected, solution3639.minTime(s, order, k));
    }

    @Test
    public void example3() {
        String s = "xy";
        int[] order = {0, 1};
        int k = 4;
        int expected = -1;
        Assertions.assertEquals(expected, solution3639.minTime(s, order, k));
    }
}