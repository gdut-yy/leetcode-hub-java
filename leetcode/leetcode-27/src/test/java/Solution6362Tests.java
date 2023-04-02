import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6362Tests {
    private final Solution6362 solution6362 = new Solution6362();

    @Test
    public void example1() {
        String s = "01000111";
        int expected = 6;
        Assertions.assertEquals(expected, solution6362.findTheLongestBalancedSubstring(s));
        Assertions.assertEquals(expected, solution6362.findTheLongestBalancedSubstring2(s));
    }

    @Test
    public void example2() {
        String s = "00111";
        int expected = 4;
        Assertions.assertEquals(expected, solution6362.findTheLongestBalancedSubstring(s));
        Assertions.assertEquals(expected, solution6362.findTheLongestBalancedSubstring2(s));
    }

    @Test
    public void example3() {
        String s = "111";
        int expected = 0;
        Assertions.assertEquals(expected, solution6362.findTheLongestBalancedSubstring(s));
        Assertions.assertEquals(expected, solution6362.findTheLongestBalancedSubstring2(s));
    }
}