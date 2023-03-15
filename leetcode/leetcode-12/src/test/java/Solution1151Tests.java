import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1151Tests {
    private final Solution1151 solution1151 = new Solution1151();

    @Test
    public void example1() {
        int[] data = {1, 0, 1, 0, 1};
        int expected = 1;
        Assertions.assertEquals(expected, solution1151.minSwaps(data));
    }

    @Test
    public void example2() {
        int[] data = {0, 0, 0, 1, 0};
        int expected = 0;
        Assertions.assertEquals(expected, solution1151.minSwaps(data));
    }

    @Test
    public void example3() {
        int[] data = {1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1};
        int expected = 3;
        Assertions.assertEquals(expected, solution1151.minSwaps(data));
    }
}
