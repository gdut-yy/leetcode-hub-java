import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3536Tests {
    private final Solution3536 solution3536 = new Solution3536();

    @Test
    public void example1() {
        int n = 31;
        int expected = 3;
        Assertions.assertEquals(expected, solution3536.maxProduct(n));
    }

    @Test
    public void example2() {
        int n = 22;
        int expected = 4;
        Assertions.assertEquals(expected, solution3536.maxProduct(n));
    }

    @Test
    public void example3() {
        int n = 124;
        int expected = 8;
        Assertions.assertEquals(expected, solution3536.maxProduct(n));
    }
}