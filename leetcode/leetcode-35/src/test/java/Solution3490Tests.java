import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3490Tests {
    private final Solution3490 solution3490 = new Solution3490();

    @Test
    public void example1() {
        int l = 10;
        int r = 20;
        int expected = 2;
        Assertions.assertEquals(expected, solution3490.beautifulNumbers(l, r));
    }

    @Test
    public void example2() {
        int l = 1;
        int r = 15;
        int expected = 10;
        Assertions.assertEquals(expected, solution3490.beautifulNumbers(l, r));
    }
}