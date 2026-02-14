import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3823Tests {
    private final Solution3823 solution3823 = new Solution3823();

    @Test
    public void example1() {
        String s = ")ebc#da@f(";
        String expected = "(fad@cb#e)";
        Assertions.assertEquals(expected, solution3823.reverseByType(s));
    }

    @Test
    public void example2() {
        String s = "z";
        String expected = "z";
        Assertions.assertEquals(expected, solution3823.reverseByType(s));
    }

    @Test
    public void example3() {
        String s = "!@#$%^&*()";
        String expected = ")(*&^%$#@!";
        Assertions.assertEquals(expected, solution3823.reverseByType(s));
    }
}