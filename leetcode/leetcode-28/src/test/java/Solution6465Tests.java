import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution6465Tests {
    private final Solution6465 solution6465 = new Solution6465();

    @Test
    public void example1() {
        String s = "cbabc";
        String expected = "baabc";
        Assertions.assertEquals(expected, solution6465.smallestString(s));
    }

    @Test
    public void example2() {
        String s = "acbbc";
        String expected = "abaab";
        Assertions.assertEquals(expected, solution6465.smallestString(s));
    }

    @Test
    public void example3() {
        String s = "leetcode";
        String expected = "kddsbncd";
        Assertions.assertEquals(expected, solution6465.smallestString(s));
    }
}