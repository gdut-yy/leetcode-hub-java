import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution972Tests {
    private final Solution972 solution972 = new Solution972();

    @Test
    public void example1() {
        String s = "0.(52)";
        String t = "0.5(25)";
        Assertions.assertTrue(solution972.isRationalEqual(s, t));
    }

    @Test
    public void example2() {
        String s = "0.1666(6)";
        String t = "0.166(66)";
        Assertions.assertTrue(solution972.isRationalEqual(s, t));
    }

    @Test
    public void example3() {
        String s = "0.9(9)";
        String t = "1.";
        Assertions.assertTrue(solution972.isRationalEqual(s, t));
    }
}
