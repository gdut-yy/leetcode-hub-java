import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6246Tests {
    private final Solution6246 solution6246 = new Solution6246();

    @Test
    public void example1() {
        String s = "coaching";
        String t = "coding";
        int expected = 4;
        Assertions.assertEquals(expected, solution6246.appendCharacters(s, t));
    }

    @Test
    public void example2() {
        String s = "abcde";
        String t = "a";
        int expected = 0;
        Assertions.assertEquals(expected, solution6246.appendCharacters(s, t));
    }

    @Test
    public void example3() {
        String s = "z";
        String t = "abcde";
        int expected = 5;
        Assertions.assertEquals(expected, solution6246.appendCharacters(s, t));
    }
}
