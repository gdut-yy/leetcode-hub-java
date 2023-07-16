import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution6924Tests {
    private final Solution6924 solution6924 = new Solution6924();

    @Test
    public void example1() {
        String word = "cbaaaabc";
        List<String> forbidden = List.of("aaa", "cb");
        int expected = 4;
        Assertions.assertEquals(expected, solution6924.longestValidSubstring(word, forbidden));
    }

    @Test
    public void example2() {
        String word = "leetcode";
        List<String> forbidden = List.of("de", "le", "e");
        int expected = 4;
        Assertions.assertEquals(expected, solution6924.longestValidSubstring(word, forbidden));
    }
}