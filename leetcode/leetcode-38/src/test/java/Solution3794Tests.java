import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3794Tests {
    private final Solution3794 solution3794 = new Solution3794();

    @Test
    public void example1() {
        String s = "abcd";
        int k = 2;
        String expected = "bacd";
        Assertions.assertEquals(expected, solution3794.reversePrefix(s, k));
    }

    @Test
    public void example2() {
        String s = "xyz";
        int k = 3;
        String expected = "zyx";
        Assertions.assertEquals(expected, solution3794.reversePrefix(s, k));
    }

    @Test
    public void example3() {
        String s = "hey";
        int k = 1;
        String expected = "hey";
        Assertions.assertEquals(expected, solution3794.reversePrefix(s, k));
    }
}