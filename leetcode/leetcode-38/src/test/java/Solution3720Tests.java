import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution3720Tests {
    private final Solution3720 solution3720 = new Solution3720();

    @Test
    public void example1() {
        String s = "abc";
        String target = "bba";
        String expected = "bca";
        Assertions.assertEquals(expected, solution3720.lexGreaterPermutation(s, target));
    }

    @Test
    public void example2() {
        String s = "leet";
        String target = "code";
        String expected = "eelt";
        Assertions.assertEquals(expected, solution3720.lexGreaterPermutation(s, target));
    }

    @Test
    public void example3() {
        String s = "baba";
        String target = "bbaa";
        String expected = "";
        Assertions.assertEquals(expected, solution3720.lexGreaterPermutation(s, target));
    }
}