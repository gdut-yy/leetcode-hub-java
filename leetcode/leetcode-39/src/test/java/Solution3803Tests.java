import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3803Tests {
    private final Solution3803 solution3803 = new Solution3803();

    @Test
    public void example1() {
        String s = "abc";
        int expected = 2;
        Assertions.assertEquals(expected, solution3803.residuePrefixes(s));
    }

    @Test
    public void example2() {
        String s = "dd";
        int expected = 1;
        Assertions.assertEquals(expected, solution3803.residuePrefixes(s));
    }

    @Test
    public void example3() {
        String s = "bob";
        int expected = 2;
        Assertions.assertEquals(expected, solution3803.residuePrefixes(s));
    }
}