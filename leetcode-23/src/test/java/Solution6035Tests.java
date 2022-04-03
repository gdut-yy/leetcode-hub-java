import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6035Tests {
    private final Solution6035 solution6035 = new Solution6035();

    @Test
    public void example1() {
        String s = "001101";
        long expected = 6;
        Assertions.assertEquals(expected, solution6035.numberOfWays(s));
    }

    @Test
    public void example2() {
        String s = "11100";
        long expected = 0;
        Assertions.assertEquals(expected, solution6035.numberOfWays(s));
    }
}
