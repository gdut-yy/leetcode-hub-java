import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution651Tests {
    private final Solution651 solution651 = new Solution651();

    @Test
    public void example1() {
        int n = 3;
        int expected = 3;
        Assertions.assertEquals(expected, solution651.maxA(n));
    }

    @Test
    public void example2() {
        int n = 7;
        int expected = 9;
        Assertions.assertEquals(expected, solution651.maxA(n));
    }
}
