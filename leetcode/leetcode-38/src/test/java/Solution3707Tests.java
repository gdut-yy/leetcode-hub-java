import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3707Tests {
    private final Solution3707 solution3707 = new Solution3707();

    @Test
    public void example1() {
        String s = "adcb";
        Assertions.assertTrue(solution3707.scoreBalance(s));
    }

    @Test
    public void example2() {
        String s = "bace";
        Assertions.assertFalse(solution3707.scoreBalance(s));
    }
}