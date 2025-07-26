import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3614Tests {
    private final Solution3614 solution3614 = new Solution3614();

    @Test
    public void example1() {
        String s = "a#b%*";
        long k = 1;
        char expected = 'a';
        Assertions.assertEquals(expected, solution3614.processStr(s, k));
    }

    @Test
    public void example2() {
        String s = "cd%#*#";
        long k = 3;
        char expected = 'd';
        Assertions.assertEquals(expected, solution3614.processStr(s, k));
    }

    @Test
    public void example3() {
        String s = "z*#";
        long k = 0;
        char expected = '.';
        Assertions.assertEquals(expected, solution3614.processStr(s, k));
    }
}