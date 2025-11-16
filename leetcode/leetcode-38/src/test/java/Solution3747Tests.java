import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3747Tests {
    private final Solution3747 solution3747 = new Solution3747();

    @Test
    public void example1() {
        long n = 10;
        long expected = 9;
        Assertions.assertEquals(expected, solution3747.countDistinct(n));
    }

    @Test
    public void example2() {
        long n = 3;
        long expected = 3;
        Assertions.assertEquals(expected, solution3747.countDistinct(n));
    }
}