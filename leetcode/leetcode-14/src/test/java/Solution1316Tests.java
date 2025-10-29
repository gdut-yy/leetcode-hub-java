import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution1316Tests {
    private final Solution1316 solution1316 = new Solution1316();

    @Test
    public void example1() {
        String text = "abcabcabc";
        int expected = 3;
        Assertions.assertEquals(expected, solution1316.distinctEchoSubstrings(text));
        Assertions.assertEquals(expected, solution1316.distinctEchoSubstrings2(text));
    }

    @Test
    public void example2() {
        String text = "leetcodeleetcode";
        int expected = 2;
        Assertions.assertEquals(expected, solution1316.distinctEchoSubstrings(text));
        Assertions.assertEquals(expected, solution1316.distinctEchoSubstrings2(text));
    }
}