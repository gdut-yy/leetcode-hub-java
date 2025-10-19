import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3697Tests {
    private final Solution3697 solution3697 = new Solution3697();

    @Test
    public void example1() {
        int n = 537;
        int[] expected = {500, 30, 7};
        Assertions.assertArrayEquals(expected, solution3697.decimalRepresentation(n));
    }

    @Test
    public void example2() {
        int n = 102;
        int[] expected = {100, 2};
        Assertions.assertArrayEquals(expected, solution3697.decimalRepresentation(n));
    }

    @Test
    public void example3() {
        int n = 6;
        int[] expected = {6};
        Assertions.assertArrayEquals(expected, solution3697.decimalRepresentation(n));
    }
}