import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3849Tests {
    private final Solution3849 solution3849 = new Solution3849();

    @Test
    public void example1() {
        String s = "101";
        String t = "011";
        String expected = "110";
        Assertions.assertEquals(expected, solution3849.maximumXor(s, t));
    }

    @Test
    public void example2() {
        String s = "0110";
        String t = "1110";
        String expected = "1101";
        Assertions.assertEquals(expected, solution3849.maximumXor(s, t));
    }

    @Test
    public void example3() {
        String s = "0101";
        String t = "1001";
        String expected = "1111";
        Assertions.assertEquals(expected, solution3849.maximumXor(s, t));
    }
}