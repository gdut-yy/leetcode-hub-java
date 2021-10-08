import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution316Tests {
    private final Solution316 solution316 = new Solution316();

    @Test
    public void example1() {
        String s = "bcabc";
        String expected = "abc";
        Assertions.assertEquals(expected, solution316.removeDuplicateLetters(s));
    }

    @Test
    public void example2() {
        String s = "cbacdcbc";
        String expected = "acdb";
        Assertions.assertEquals(expected, solution316.removeDuplicateLetters(s));
    }
}
