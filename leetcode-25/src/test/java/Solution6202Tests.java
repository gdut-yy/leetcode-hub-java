import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6202Tests {
    private final Solution6202 solution6202 = new Solution6202();

    @Test
    public void example1() {
        String s = "zza";
        String expected = "azz";
        Assertions.assertEquals(expected, solution6202.robotWithString(s));
    }

    @Test
    public void example2() {
        String s = "bac";
        String expected = "abc";
        Assertions.assertEquals(expected, solution6202.robotWithString(s));
    }

    @Test
    public void example3() {
        String s = "bdda";
        String expected = "addb";
        Assertions.assertEquals(expected, solution6202.robotWithString(s));
    }
}
