import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3694Tests {
    private final Solution3694 solution3694 = new Solution3694();

    @Test
    public void example1() {
        String s = "LUL";
        int k = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3694.distinctPoints(s, k));
    }

    @Test
    public void example2() {
        String s = "UDLR";
        int k = 4;
        int expected = 1;
        Assertions.assertEquals(expected, solution3694.distinctPoints(s, k));
    }

    @Test
    public void example3() {
        String s = "UU";
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution3694.distinctPoints(s, k));
    }
}