import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3561Tests {
    private final Solution3561 solution3561 = new Solution3561();

    @Test
    public void example1() {
        String s = "abc";
        String expected = "c";
        Assertions.assertEquals(expected, solution3561.resultingString(s));
    }

    @Test
    public void example2() {
        String s = "adcb";
        String expected = "";
        Assertions.assertEquals(expected, solution3561.resultingString(s));
    }

    @Test
    public void example3() {
        String s = "zadb";
        String expected = "db";
        Assertions.assertEquals(expected, solution3561.resultingString(s));
    }
}