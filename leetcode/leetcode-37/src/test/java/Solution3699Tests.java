import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3699Tests {
    private final Solution3699 solution3699 = new Solution3699();

    @Test
    public void example1() {
        int n = 3;
        int l = 4;
        int r = 5;
        int expected = 2;
        Assertions.assertEquals(expected, solution3699.zigZagArrays(n, l, r));
    }

    @Test
    public void example2() {
        int n = 3;
        int l = 1;
        int r = 3;
        int expected = 10;
        Assertions.assertEquals(expected, solution3699.zigZagArrays(n, l, r));
    }
}