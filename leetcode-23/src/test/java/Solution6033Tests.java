import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6033Tests {
    private final Solution6033 solution6033 = new Solution6033();

    @Test
    public void example1() {
        int start = 10;
        int goal = 7;
        int expected = 3;
        Assertions.assertEquals(expected, solution6033.minBitFlips(start, goal));
    }

    @Test
    public void example2() {
        int start = 3;
        int goal = 4;
        int expected = 3;
        Assertions.assertEquals(expected, solution6033.minBitFlips(start, goal));
    }
}
