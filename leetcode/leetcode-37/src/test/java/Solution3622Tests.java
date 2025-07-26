import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3622Tests {
    private final Solution3622 solution3622 = new Solution3622();

    @Test
    public void example1() {
        int n = 99;
        Assertions.assertTrue(solution3622.checkDivisibility(n));
    }

    @Test
    public void example2() {
        int n = 23;
        Assertions.assertFalse(solution3622.checkDivisibility(n));
    }
}