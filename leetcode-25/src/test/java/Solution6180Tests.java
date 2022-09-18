import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6180Tests {
    private final Solution6180 solution6180 = new Solution6180();

    @Test
    public void example1() {
        int n = 5;
        int expected = 10;
        Assertions.assertEquals(expected, solution6180.smallestEvenMultiple(n));
        Assertions.assertEquals(expected, solution6180.smallestEvenMultiple2(n));
    }

    @Test
    public void example2() {
        int n = 6;
        int expected = 6;
        Assertions.assertEquals(expected, solution6180.smallestEvenMultiple(n));
        Assertions.assertEquals(expected, solution6180.smallestEvenMultiple2(n));
    }
}
