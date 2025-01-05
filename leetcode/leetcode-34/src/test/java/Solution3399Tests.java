import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3399Tests {
    private final Solution3399 solution3399 = new Solution3399();

    @Test
    public void example1() {
        String s = "000001";
        int numOps = 1;
        int expected = 2;
        Assertions.assertEquals(expected, solution3399.minLength(s, numOps));
    }

    @Test
    public void example2() {
        String s = "0000";
        int numOps = 2;
        int expected = 1;
        Assertions.assertEquals(expected, solution3399.minLength(s, numOps));
    }

    @Test
    public void example3() {
        String s = "0101";
        int numOps = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution3399.minLength(s, numOps));
    }
}