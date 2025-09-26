import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3677Tests {
    private final Solution3677 solution3677 = new Solution3677();

    @Test
    public void example1() {
        long n = 9;
        int expected = 6;
        Assertions.assertEquals(expected, solution3677.countBinaryPalindromes(n));
    }

    @Test
    public void example2() {
        long n = 0;
        int expected = 1;
        Assertions.assertEquals(expected, solution3677.countBinaryPalindromes(n));
    }
}