import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6245Tests {
    private final Solution6245 solution6245 = new Solution6245();

    @Test
    public void example1() {
        int n = 8;
        int expected = 6;
        Assertions.assertEquals(expected, solution6245.pivotInteger(n));
    }

    @Test
    public void example2() {
        int n = 1;
        int expected = 1;
        Assertions.assertEquals(expected, solution6245.pivotInteger(n));
    }

    @Test
    public void example3() {
        int n = 4;
        int expected = -1;
        Assertions.assertEquals(expected, solution6245.pivotInteger(n));
    }
}
