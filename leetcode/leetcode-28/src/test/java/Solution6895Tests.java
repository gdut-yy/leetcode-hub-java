import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6895Tests {
    private final Solution6895 solution6895 = new Solution6895();

    @Test
    public void example1() {
        int x = 2;
        int y = 5;
        int z = 1;
        int expected = 12;
        Assertions.assertEquals(expected, solution6895.longestString(x, y, z));
    }

    @Test
    public void example2() {
        int x = 3;
        int y = 2;
        int z = 2;
        int expected = 14;
        Assertions.assertEquals(expected, solution6895.longestString(x, y, z));
    }
}