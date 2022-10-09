import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6201Tests {
    private final Solution6201 solution6201 = new Solution6201();

    @Test
    public void example1() {
        int[] pref = {5, 2, 0, 3, 1};
        int[] expected = {5, 7, 2, 3, 2};
        Assertions.assertArrayEquals(expected, solution6201.findArray(pref));
    }

    @Test
    public void example2() {
        int[] pref = {13};
        int[] expected = {13};
        Assertions.assertArrayEquals(expected, solution6201.findArray(pref));
    }
}
