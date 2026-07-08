import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3950Tests {
    private final Solution3950.V1 solution3950_v1 = new Solution3950.V1();
    private final Solution3950.V2 solution3950_v2 = new Solution3950.V2();

    @Test
    public void example1() {
        int n = 6;
        Assertions.assertTrue(solution3950_v1.consecutiveSetBits(n));
        Assertions.assertTrue(solution3950_v2.consecutiveSetBits(n));
    }

    @Test
    public void example2() {
        int n = 5;
        Assertions.assertFalse(solution3950_v1.consecutiveSetBits(n));
        Assertions.assertFalse(solution3950_v2.consecutiveSetBits(n));
    }
}