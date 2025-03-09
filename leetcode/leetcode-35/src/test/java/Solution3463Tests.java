import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3463Tests {
    private final Solution3463 solution3463 = new Solution3463();

    @Test
    public void example1() {
        String s = "3902";
        Assertions.assertTrue(solution3463.hasSameDigits(s));
    }

    @Test
    public void example2() {
        String s = "34789";
        Assertions.assertFalse(solution3463.hasSameDigits(s));
    }
}