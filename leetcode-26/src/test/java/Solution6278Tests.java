import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6278Tests {
    private final Solution6278 solution6278 = new Solution6278();

    @Test
    public void example1() {
        int num = 7;
        int expected = 1;
        Assertions.assertEquals(expected, solution6278.countDigits(num));
    }

    @Test
    public void example2() {
        int num = 121;
        int expected = 2;
        Assertions.assertEquals(expected, solution6278.countDigits(num));
    }

    @Test
    public void example3() {
        int num = 1248;
        int expected = 4;
        Assertions.assertEquals(expected, solution6278.countDigits(num));
    }
}
