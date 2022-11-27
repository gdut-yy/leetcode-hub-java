import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution248Tests {
    private final Solution248 solution248 = new Solution248();

    @Test
    public void example1() {
        String low = "50";
        String high = "100";
        int expected = 3;
        Assertions.assertEquals(expected, solution248.strobogrammaticInRange(low, high));
    }

    @Test
    public void example2() {
        String low = "0";
        String high = "0";
        int expected = 1;
        Assertions.assertEquals(expected, solution248.strobogrammaticInRange(low, high));
    }
}
