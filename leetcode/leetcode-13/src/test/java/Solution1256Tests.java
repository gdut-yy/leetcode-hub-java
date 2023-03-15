import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1256Tests {
    private final Solution1256 solution1256 = new Solution1256();

    @Test
    public void example1() {
        int num = 23;
        String expected = "1000";
        Assertions.assertEquals(expected, solution1256.encode(num));
    }

    @Test
    public void example2() {
        int num = 107;
        String expected = "101100";
        Assertions.assertEquals(expected, solution1256.encode(num));
    }
}