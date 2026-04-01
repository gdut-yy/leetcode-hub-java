import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3848Tests {
    private final Solution3848 solution3848 = new Solution3848();

    @Test
    public void example1() {
        int n = 145;
        Assertions.assertTrue(solution3848.isDigitorialPermutation(n));
    }

    @Test
    public void example2() {
        int n = 10;
        Assertions.assertFalse(solution3848.isDigitorialPermutation(n));
    }
}