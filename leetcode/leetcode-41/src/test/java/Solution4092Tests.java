import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4092Tests {
    private final Solution4092 solution4092 = new Solution4092();

    @Test
    public void example1() {
        int a = 14;
        int b = 6;
        int expected = 6;
        Assertions.assertEquals(expected, solution4092.calculateScore(a, b));
    }

    @Test
    public void example2() {
        int a = 5;
        int b = 15;
        int expected = 2;
        Assertions.assertEquals(expected, solution4092.calculateScore(a, b));
    }

    @Test
    public void example3() {
        int a = 10;
        int b = 12;
        int expected = 4;
        Assertions.assertEquals(expected, solution4092.calculateScore(a, b));
    }
}
