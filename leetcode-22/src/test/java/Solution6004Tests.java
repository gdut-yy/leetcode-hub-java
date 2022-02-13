import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6004Tests {
    private final Solution6004 solution6004 = new Solution6004();

    @Test
    public void example1() {
        int num1 = 2;
        int num2 = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution6004.countOperations(num1, num2));
    }

    @Test
    public void example12() {
        int num1 = 10;
        int num2 = 10;
        int expected = 1;
        Assertions.assertEquals(expected, solution6004.countOperations(num1, num2));
    }
}
