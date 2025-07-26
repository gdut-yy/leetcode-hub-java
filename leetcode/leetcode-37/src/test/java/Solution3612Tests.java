import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3612Tests {
    private final Solution3612 solution3612 = new Solution3612();

    @Test
    public void example1() {
        String s = "a#b%*";
        String expected = "ba";
        Assertions.assertEquals(expected, solution3612.processStr(s));
    }

    @Test
    public void example2() {
        String s = "z*#";
        String expected = "";
        Assertions.assertEquals(expected, solution3612.processStr(s));
    }
}