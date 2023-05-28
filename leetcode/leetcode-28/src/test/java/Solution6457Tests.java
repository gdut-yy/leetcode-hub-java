import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6457Tests {
    private final Solution6457 solution6457 = new Solution6457();

    @Test
    public void example1() {
        String num = "51230100";
        String expected = "512301";
        Assertions.assertEquals(expected, solution6457.removeTrailingZeros(num));
    }

    @Test
    public void example2() {
        String num = "123";
        String expected = "123";
        Assertions.assertEquals(expected, solution6457.removeTrailingZeros(num));
    }
}