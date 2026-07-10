import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3959Tests {
    private final Solution3959 solution3959 = new Solution3959();

    @Test
    public void example1() {
        int n = 1000;
        Assertions.assertFalse(solution3959.checkGoodInteger(n));
    }

    @Test
    public void example2() {
        int n = 19;
        Assertions.assertTrue(solution3959.checkGoodInteger(n));
    }
}