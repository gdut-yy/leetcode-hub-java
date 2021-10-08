import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1038Tests {
    private final Solution1038 solution1038 = new Solution1038();

    @Test
    public void example1() {
        String s = "bcabc";
        String expected = "abc";
        Assertions.assertEquals(expected, solution1038.smallestSubsequence(s));
    }

    @Test
    public void example2() {
        String s = "cbacdcbc";
        String expected = "acdb";
        Assertions.assertEquals(expected, solution1038.smallestSubsequence(s));
    }
}
