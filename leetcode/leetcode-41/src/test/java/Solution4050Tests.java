import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4050Tests {
    private final Solution4050 solution4050 = new Solution4050();

    @Test
    public void example1() {
        int n = 2;
        int expected = 3;
        Assertions.assertEquals(expected, solution4050.minDays(n));
    }

    @Test
    public void example2() {
        int n = 9;
        int expected = 6;
        Assertions.assertEquals(expected, solution4050.minDays(n));
    }

    @Test
    public void example3() {
        int n = 12;
        int expected = 7;
        Assertions.assertEquals(expected, solution4050.minDays(n));
    }
}