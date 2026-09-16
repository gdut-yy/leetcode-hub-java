import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4000Tests {
    private final Solution4000 solution4000 = new Solution4000();

    @Test
    public void example1() {
        int n = 2;
        int s = 9;
        int expected = 90;
        Assertions.assertEquals(expected, solution4000.largestInteger(n, s));
    }

    @Test
    public void example2() {
        int n = 2;
        int s = 19;
        int expected = -1;
        Assertions.assertEquals(expected, solution4000.largestInteger(n, s));
    }

    @Test
    public void example3() {
        int n = 5;
        int s = 0;
        int expected = 0;
        Assertions.assertEquals(expected, solution4000.largestInteger(n, s));
    }
}