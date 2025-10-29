import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1896Tests {
    private final Solution1896 solution1896 = new Solution1896();

    @Test
    public void example1() {
        String expression = "1&(0|1)";
        int expected = 1;
        Assertions.assertEquals(expected, solution1896.minOperationsToFlip(expression));
    }

    @Test
    public void example2() {
        String expression = "(0&0)&(0&0&0)";
        int expected = 3;
        Assertions.assertEquals(expected, solution1896.minOperationsToFlip(expression));
    }

    @Test
    public void example3() {
        String expression = "(0|(1|0&1))";
        int expected = 1;
        Assertions.assertEquals(expected, solution1896.minOperationsToFlip(expression));
    }
}