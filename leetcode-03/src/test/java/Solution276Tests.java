import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution276Tests {
    private final Solution276 solution276 = new Solution276();

    @Test
    public void example1() {
        int n = 3;
        int k = 2;
        int expected = 6;
        Assertions.assertEquals(expected, solution276.numWays(n, k));
    }

    @Test
    public void example2() {
        int n = 1;
        int k = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution276.numWays(n, k));
    }

    @Test
    public void example3() {
        int n = 7;
        int k = 2;
        int expected = 42;
        Assertions.assertEquals(expected, solution276.numWays(n, k));
    }
}
