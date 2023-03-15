import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1056Tests {
    private final Solution1056 solution1056 = new Solution1056();

    @Test
    public void example1() {
        int n = 6;
        Assertions.assertTrue(solution1056.confusingNumber(n));
    }

    @Test
    public void example2() {
        int n = 89;
        Assertions.assertTrue(solution1056.confusingNumber(n));
    }

    @Test
    public void example3() {
        int n = 11;
        Assertions.assertFalse(solution1056.confusingNumber(n));
    }

    @Test
    public void example4() {
        int n = 25;
        Assertions.assertFalse(solution1056.confusingNumber(n));
    }
}
