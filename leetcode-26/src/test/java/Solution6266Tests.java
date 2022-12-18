import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6266Tests {
    private final Solution6266 solution6266 = new Solution6266();

    @Test
    public void example1() {
        int n = 15;
        int expected = 5;
        Assertions.assertEquals(expected, solution6266.smallestValue(n));
    }

    @Test
    public void example2() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution6266.smallestValue(n));
    }
}