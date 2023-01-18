import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution291Tests {
    private final Solution291 solution291 = new Solution291();

    @Test
    public void example1() {
        String pattern = "abab";
        String s = "redblueredblue";
        Assertions.assertTrue(solution291.wordPatternMatch(pattern, s));
    }

    @Test
    public void example2() {
        String pattern = "aaaa";
        String s = "asdasdasdasd";
        Assertions.assertTrue(solution291.wordPatternMatch(pattern, s));
    }

    @Test
    public void example3() {
        String pattern = "aabb";
        String s = "xyzabcxzyabc";
        Assertions.assertFalse(solution291.wordPatternMatch(pattern, s));
    }

    // 补充用例
    @Test
    public void example4() {
        // https://leetcode.cn/submissions/detail/395818609/
        String pattern = "d";
        String s = "e";
        Assertions.assertTrue(solution291.wordPatternMatch(pattern, s));
    }
}
