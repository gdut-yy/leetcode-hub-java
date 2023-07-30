import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6957Tests {
    private final Solution6957 solution6957 = new Solution6957();

    @Test
    public void example1() {
        String low = "1";
        String high = "11";
        int expected = 10;
        Assertions.assertEquals(expected, solution6957.countSteppingNumbers(low, high));
    }

    @Test
    public void example2() {
        String low = "90";
        String high = "101";
        int expected = 2;
        Assertions.assertEquals(expected, solution6957.countSteppingNumbers(low, high));
    }
}