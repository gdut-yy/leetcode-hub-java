import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3765Tests {
    private final Solution3765 solution3765 = new Solution3765();

    @Test
    public void example1() {
        int num = 23;
        Assertions.assertTrue(solution3765.completePrime(num));
    }

    @Test
    public void example2() {
        int num = 39;
        Assertions.assertFalse(solution3765.completePrime(num));
    }

    @Test
    public void example3() {
        int num = 7;
        Assertions.assertTrue(solution3765.completePrime(num));
    }
}