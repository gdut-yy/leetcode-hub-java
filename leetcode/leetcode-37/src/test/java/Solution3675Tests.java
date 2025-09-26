import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3675Tests {
    private final Solution3675 solution3675 = new Solution3675();

    @Test
    public void example1() {
        String s = "yz";
        int expected = 2;
        Assertions.assertEquals(expected, solution3675.minOperations(s));
    }

    @Test
    public void example2() {
        String s = "a";
        int expected = 0;
        Assertions.assertEquals(expected, solution3675.minOperations(s));
    }
}