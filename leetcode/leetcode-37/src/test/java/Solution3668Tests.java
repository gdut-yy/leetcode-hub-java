import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3668Tests {
    private final Solution3668 solution3668 = new Solution3668();

    @Test
    public void example1() {
        int[] order = {3, 1, 2, 5, 4};
        int[] friends = {1, 3, 4};
        int[] expected = {3, 1, 4};
        Assertions.assertArrayEquals(expected, solution3668.recoverOrder(order, friends));
    }

    @Test
    public void example2() {
        int[] order = {1, 4, 5, 3, 2};
        int[] friends = {2, 5};
        int[] expected = {5, 2};
        Assertions.assertArrayEquals(expected, solution3668.recoverOrder(order, friends));
    }
}