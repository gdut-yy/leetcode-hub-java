import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3908Tests {
    private final Solution3908 solution3908 = new Solution3908();

    @Test
    public void example1() {
        int n = 101;
        int x = 0;
        Assertions.assertTrue(solution3908.validDigit(n, x));
    }

    @Test
    public void example2() {
        int n = 232;
        int x = 2;
        Assertions.assertFalse(solution3908.validDigit(n, x));
    }

    @Test
    public void example3() {
        int n = 5;
        int x = 1;
        Assertions.assertFalse(solution3908.validDigit(n, x));
    }
}