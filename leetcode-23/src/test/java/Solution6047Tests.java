import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6047Tests {
    private final Solution6047 solution6047 = new Solution6047();

    @Test
    public void example1() {
        String number = "123";
        char digit = '3';
        String expected = "12";
        Assertions.assertEquals(expected, solution6047.removeDigit(number, digit));
    }

    @Test
    public void example2() {
        String number = "1231";
        char digit = '1';
        String expected = "231";
        Assertions.assertEquals(expected, solution6047.removeDigit(number, digit));
    }

    @Test
    public void example3() {
        String number = "551";
        char digit = '5';
        String expected = "51";
        Assertions.assertEquals(expected, solution6047.removeDigit(number, digit));
    }
}
