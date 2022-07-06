import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution772Tests {
    private final Solution772 solution772 = new Solution772();

    @Test
    public void example1() {
        String s = "1+1";
        int expected = 2;
        Assertions.assertEquals(expected, solution772.calculate(s));
    }

    @Test
    public void example2() {
        String s = "6-4/2";
        int expected = 4;
        Assertions.assertEquals(expected, solution772.calculate(s));
    }

    @Test
    public void example3() {
        String s = "2*(5+5*2)/3+(6/2+8)";
        int expected = 21;
        Assertions.assertEquals(expected, solution772.calculate(s));
    }

    @Test
    public void example4() {
        String s = "(2+6*3+5-(3*14/7+2)*5)+3";
        int expected = -12;
        Assertions.assertEquals(expected, solution772.calculate(s));
    }

    @Test
    public void example5() {
        String s = "0";
        int expected = 0;
        Assertions.assertEquals(expected, solution772.calculate(s));
    }
}
