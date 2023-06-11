import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6461Tests {
    private final Solution6461 solution6461 = new Solution6461();

    @Test
    public void example1() {
        int n = 192;
        Assertions.assertTrue(solution6461.isFascinating(n));
    }

    @Test
    public void example2() {
        int n = 100;
        Assertions.assertFalse(solution6461.isFascinating(n));
    }
}