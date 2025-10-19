import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3703Tests {
    private final Solution3703 solution3703 = new Solution3703();

    @Test
    public void example1() {
        String s = "(())";
        int k = 1;
        String expected = "";
        Assertions.assertEquals(expected, solution3703.removeSubstring(s, k));
    }

    @Test
    public void example2() {
        String s = "(()(";
        int k = 1;
        String expected = "((";
        Assertions.assertEquals(expected, solution3703.removeSubstring(s, k));
    }

    @Test
    public void example3() {
        String s = "((()))()()()";
        int k = 3;
        String expected = "()()()";
        Assertions.assertEquals(expected, solution3703.removeSubstring(s, k));
    }
}