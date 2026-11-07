import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4078Tests {
    private final Solution4078 solution4078 = new Solution4078();

    @Test
    public void example1() {
        int n = 16;
        Assertions.assertTrue(solution4078.threeFibonacciSum(n));
    }

    @Test
    public void example2() {
        int n = 8;
        Assertions.assertFalse(solution4078.threeFibonacciSum(n));
    }

    @Test
    public void example3() {
        int n = 2;
        Assertions.assertTrue(solution4078.threeFibonacciSum(n));
    }
}
