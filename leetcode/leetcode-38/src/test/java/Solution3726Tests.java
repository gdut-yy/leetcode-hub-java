import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3726Tests {
    private final Solution3726 solution3726 = new Solution3726();

    @Test
    public void example1() {
        long n = 1020030;
        long expected = 123;
        Assertions.assertEquals(expected, solution3726.removeZeros(n));
    }

    @Test
    public void example2() {
        long n = 1;
        long expected = 1;
        Assertions.assertEquals(expected, solution3726.removeZeros(n));
    }
}