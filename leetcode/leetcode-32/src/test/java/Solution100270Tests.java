import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution100270Tests {
    private final Solution100270 solution100270 = new Solution100270();

    @Test
    public void example1() {
        String s = "hello";
        int expected = 13;
        Assertions.assertEquals(expected, solution100270.scoreOfString(s));
    }

    @Test
    public void example2() {
        String s = "zaz";
        int expected = 50;
        Assertions.assertEquals(expected, solution100270.scoreOfString(s));
    }
}