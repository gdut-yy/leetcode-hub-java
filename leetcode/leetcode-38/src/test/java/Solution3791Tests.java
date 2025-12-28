import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3791Tests {
    private final Solution3791 solution3791 = new Solution3791();

    @Test
    public void example1() {
        long low = 1;
        long high = 100;
        long expected = 9;
        Assertions.assertEquals(expected, solution3791.countBalanced(low, high));
    }

    @Test
    public void example2() {
        long low = 120;
        long high = 129;
        long expected = 1;
        Assertions.assertEquals(expected, solution3791.countBalanced(low, high));
    }

    @Test
    public void example3() {
        long low = 1234;
        long high = 1234;
        long expected = 0;
        Assertions.assertEquals(expected, solution3791.countBalanced(low, high));
    }
}