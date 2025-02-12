import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3438Tests {
    private final Solution3438 solution3438 = new Solution3438();

    @Test
    public void example1() {
        String s = "2523533";
        String expected = "23";
        Assertions.assertEquals(expected, solution3438.findValidPair(s));
    }

    @Test
    public void example2() {
        String s = "221";
        String expected = "21";
        Assertions.assertEquals(expected, solution3438.findValidPair(s));
    }

    @Test
    public void example3() {
        String s = "22";
        String expected = "";
        Assertions.assertEquals(expected, solution3438.findValidPair(s));
    }
}