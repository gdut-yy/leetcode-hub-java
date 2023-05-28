import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6455Tests {
    private final Solution6455 solution6455 = new Solution6455();

    @Test
    public void example1() {
        String s = "0011";
        long expected = 2;
        Assertions.assertEquals(expected, solution6455.minimumCost(s));
    }

    @Test
    public void example2() {
        String s = "010101";
        long expected = 9;
        Assertions.assertEquals(expected, solution6455.minimumCost(s));
    }
}