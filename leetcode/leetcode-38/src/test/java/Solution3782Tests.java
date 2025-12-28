import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3782Tests {
    private final Solution3782 solution3782 = new Solution3782();

    @Test
    public void example1() {
        long n = 8;
        long expected = 3;
        Assertions.assertEquals(expected, solution3782.lastInteger(n));
    }

    @Test
    public void example2() {
        long n = 5;
        long expected = 1;
        Assertions.assertEquals(expected, solution3782.lastInteger(n));
    }

    @Test
    public void example3() {
        long n = 1;
        long expected = 1;
        Assertions.assertEquals(expected, solution3782.lastInteger(n));
    }
}