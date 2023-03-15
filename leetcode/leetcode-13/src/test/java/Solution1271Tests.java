import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1271Tests {
    private final Solution1271 solution1271 = new Solution1271();

    @Test
    public void example1() {
        String num = "257";
        String expected = "IOI";
        Assertions.assertEquals(expected, solution1271.toHexspeak(num));
    }

    @Test
    public void example2() {
        String num = "3";
        String expected = "ERROR";
        Assertions.assertEquals(expected, solution1271.toHexspeak(num));
    }
}