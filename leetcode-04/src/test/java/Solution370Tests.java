import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution370Tests {
    private final Solution370 solution370 = new Solution370();

    @Test
    public void example1() {
        int length = 5;
        int[][] updates = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        int[] expected = {-2, 0, 3, 5, 3};
        Assertions.assertArrayEquals(expected, solution370.getModifiedArray(length, updates));
    }
}
