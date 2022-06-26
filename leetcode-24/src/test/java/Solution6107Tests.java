import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6107Tests {
    private final Solution6107 solution6107 = new Solution6107();

    @Test
    public void example1() {
        int n = 4;
        int expected = 184;
        Assertions.assertEquals(expected, solution6107.distinctSequences(n));
    }

    @Test
    public void example2() {
        int n = 2;
        int expected = 22;
        Assertions.assertEquals(expected, solution6107.distinctSequences(n));
    }
}
