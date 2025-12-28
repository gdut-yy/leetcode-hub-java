import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3783Tests {
    private final Solution3783 solution3783 = new Solution3783();

    @Test
    public void example1() {
        int n = 25;
        int expected = 27;
        Assertions.assertEquals(expected, solution3783.mirrorDistance(n));
    }

    @Test
    public void example2() {
        int n = 10;
        int expected = 9;
        Assertions.assertEquals(expected, solution3783.mirrorDistance(n));
    }

    @Test
    public void example3() {
        int n = 7;
        int expected = 0;
        Assertions.assertEquals(expected, solution3783.mirrorDistance(n));
    }
}