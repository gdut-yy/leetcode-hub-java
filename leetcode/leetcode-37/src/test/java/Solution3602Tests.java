import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3602Tests {
    private final Solution3602 solution3602 = new Solution3602();

    @Test
    public void example1() {
        int n = 13;
        String expected = "A91P1";
        Assertions.assertEquals(expected, solution3602.concatHex36(n));
    }

    @Test
    public void example2() {
        int n = 36;
        String expected = "5101000";
        Assertions.assertEquals(expected, solution3602.concatHex36(n));
    }
}