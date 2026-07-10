import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3983Tests {
    private final Solution3983 solution3983 = new Solution3983();

    @Test
    public void example1() {
        String s = "cat";
        String t = "chat";
        Assertions.assertTrue(solution3983.canMakeSubsequence(s, t));
    }

    @Test
    public void example2() {
        String s = "plane";
        String t = "apple";
        Assertions.assertFalse(solution3983.canMakeSubsequence(s, t));
    }
}