import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution4002Tests {
    private final Solution4002 solution4002 = new Solution4002();

    @Test
    public void example1() {
        int n = 5;
        int k = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution4002.countValidSequences(n, k));
    }

    @Test
    public void example2() {
        int n = 3;
        int k = 2;
        int expected = 2;
        Assertions.assertEquals(expected, solution4002.countValidSequences(n, k));
    }

    @Test
    public void example3() {
        int n = 5;
        int k = 5;
        int expected = 0;
        Assertions.assertEquals(expected, solution4002.countValidSequences(n, k));
    }
}