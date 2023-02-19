import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6365Tests {
    private final Solution6365 solution6365 = new Solution6365();

    @Test
    public void example1() {
        int n = 39;
        int expected = 3;
        Assertions.assertEquals(expected, solution6365.minOperations(n));
    }

    @Test
    public void example2() {
        int n = 54;
        int expected = 3;
        Assertions.assertEquals(expected, solution6365.minOperations(n));
    }
}