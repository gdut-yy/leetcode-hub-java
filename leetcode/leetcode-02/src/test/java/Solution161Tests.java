import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution161Tests {
    private final Solution161 solution161 = new Solution161();

    @Test
    public void example1() {
        String s = "ab";
        String t = "acb";
        Assertions.assertTrue(solution161.isOneEditDistance(s, t));
    }

    @Test
    public void example2() {
        String s = "cab";
        String t = "ad";
        Assertions.assertFalse(solution161.isOneEditDistance(s, t));
    }

    @Test
    public void example3() {
        String s = "1203";
        String t = "1213";
        Assertions.assertTrue(solution161.isOneEditDistance(s, t));
    }
}
