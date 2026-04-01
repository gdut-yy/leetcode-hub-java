import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3869Tests {
    private final Solution3869 solution3869 = new Solution3869();

    @Test
    public void example1() {
        long l = 8;
        long r = 10;
        long expected = 3;
        Assertions.assertEquals(expected, solution3869.countFancy(l, r));
    }

    @Test
    public void example2() {
        long l = 12340;
        long r = 12341;
        long expected = 1;
        Assertions.assertEquals(expected, solution3869.countFancy(l, r));
    }

    @Test
    public void example3() {
        long l = 123456788;
        long r = 123456788;
        long expected = 0;
        Assertions.assertEquals(expected, solution3869.countFancy(l, r));
    }
}