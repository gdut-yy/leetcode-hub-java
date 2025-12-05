import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3754Tests {
    private final Solution3754 solution3754 = new Solution3754();

    @Test
    public void example1() {
        int n = 10203004;
        int expected = 12340;
        Assertions.assertEquals(expected, solution3754.sumAndMultiply(n));
    }

    @Test
    public void example2() {
        int n = 1000;
        int expected = 1;
        Assertions.assertEquals(expected, solution3754.sumAndMultiply(n));
    }
}