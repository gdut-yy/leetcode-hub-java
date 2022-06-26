import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6104Tests {
    private final Solution6104 solution6104 = new Solution6104();

    @Test
    public void example1() {
        String s = "l|*e*et|c**o|*de|";
        int expected = 2;
        Assertions.assertEquals(expected, solution6104.countAsterisks(s));
    }

    @Test
    public void example2() {
        String s = "iamprogrammer";
        int expected = 0;
        Assertions.assertEquals(expected, solution6104.countAsterisks(s));
    }

    @Test
    public void example3() {
        String s = "yo|uar|e**|b|e***au|tifu|l";
        int expected = 5;
        Assertions.assertEquals(expected, solution6104.countAsterisks(s));
    }
}
