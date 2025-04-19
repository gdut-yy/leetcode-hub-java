import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3519Tests {
    private final Solution3519 solution3519 = new Solution3519();

    @Test
    public void example1() {
        String l = "23";
        String r = "28";
        int b = 8;
        int expected = 3;
        Assertions.assertEquals(expected, solution3519.countNumbers(l, r, b));
    }

    @Test
    public void example2() {
        String l = "2";
        String r = "7";
        int b = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution3519.countNumbers(l, r, b));
    }
}