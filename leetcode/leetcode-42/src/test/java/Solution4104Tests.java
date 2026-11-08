import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4104Tests {
    private final Solution4104 solution4104 = new Solution4104();

    @Test
    public void example1() {
        String s = "abac";
        long expected = 9;
        Assertions.assertEquals(expected, solution4104.countValidSubstrings(s));
    }

    @Test
    public void example2() {
        String s = "abc";
        long expected = 5;
        Assertions.assertEquals(expected, solution4104.countValidSubstrings(s));
    }

    @Test
    public void example3() {
        String s = "ac";
        long expected = 3;
        Assertions.assertEquals(expected, solution4104.countValidSubstrings(s));
    }
}
