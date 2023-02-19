import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6359Tests {
    private final Solution6359 solution6359 = new Solution6359();

    @Test
    public void example1() {
        int num = 11891;
        int expected = 99009;
        Assertions.assertEquals(expected, solution6359.minMaxDifference(num));
    }

    @Test
    public void example2() {
        int num = 90;
        int expected = 99;
        Assertions.assertEquals(expected, solution6359.minMaxDifference(num));
    }
}