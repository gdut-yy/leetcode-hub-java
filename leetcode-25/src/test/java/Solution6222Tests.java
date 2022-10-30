import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6222Tests {
    private final Solution6222 solution6222 = new Solution6222();

    @Test
    public void example1() {
        long n = 16;
        int target = 6;
        long expected = 4;
        Assertions.assertEquals(expected, solution6222.makeIntegerBeautiful(n, target));
    }

    @Test
    public void example2() {
        long n = 467;
        int target = 6;
        long expected = 33;
        Assertions.assertEquals(expected, solution6222.makeIntegerBeautiful(n, target));
    }

    @Test
    public void example3() {
        long n = 1;
        int target = 1;
        long expected = 0;
        Assertions.assertEquals(expected, solution6222.makeIntegerBeautiful(n, target));
    }
}
