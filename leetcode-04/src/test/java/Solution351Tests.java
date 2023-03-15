import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution351Tests {
    private final Solution351 solution351 = new Solution351();

    @Test
    public void example1() {
        int m = 1;
        int n = 1;
        int expected = 9;
        Assertions.assertEquals(expected, solution351.numberOfPatterns(m, n));
    }

    @Test
    public void example2() {
        int m = 1;
        int n = 2;
        int expected = 65;
        Assertions.assertEquals(expected, solution351.numberOfPatterns(m, n));
    }
}
