import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6038Tests {
    private final Solution6038 solution6038 = new Solution6038();

    @Test
    public void example1() {
        String expression = "247+38";
        String expected = "2(47+38)";
        Assertions.assertEquals(expected, solution6038.minimizeResult(expression));
    }

    @Test
    public void example2() {
        String expression = "12+34";
        String expected = "1(2+3)4";
        Assertions.assertEquals(expected, solution6038.minimizeResult(expression));
    }

    @Test
    public void example3() {
        String expression = "999+999";
        String expected = "(999+999)";
        Assertions.assertEquals(expected, solution6038.minimizeResult(expression));
    }
}
