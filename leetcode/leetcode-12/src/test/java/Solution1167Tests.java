import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1167Tests {
    private final Solution1167 solution1167 = new Solution1167();

    @Test
    public void example1() {
        int[] sticks = {2, 4, 3};
        int expected = 14;
        Assertions.assertEquals(expected, solution1167.connectSticks(sticks));
    }

    @Test
    public void example2() {
        int[] sticks = {1, 8, 3, 5};
        int expected = 30;
        Assertions.assertEquals(expected, solution1167.connectSticks(sticks));
    }

    @Test
    public void example3() {
        int[] sticks = {5};
        int expected = 0;
        Assertions.assertEquals(expected, solution1167.connectSticks(sticks));
    }
}